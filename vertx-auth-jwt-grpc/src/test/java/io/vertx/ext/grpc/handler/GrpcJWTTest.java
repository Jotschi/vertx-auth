package io.vertx.ext.grpc.handler;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.grpc.MethodDescriptor;
import io.metaloom.loom.poc.proto.GreeterGrpc;
import io.metaloom.loom.poc.proto.HelloReply;
import io.metaloom.loom.poc.proto.HelloRequest;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.SocketAddress;
import io.vertx.ext.auth.KeyStoreOptions;
import io.vertx.ext.auth.User;
import io.vertx.ext.auth.authentication.TokenCredentials;
import io.vertx.ext.auth.handler.JWTClientHandler;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTAuthOptions;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.RunTestOnContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import io.vertx.grpc.client.GrpcClient;
import io.vertx.grpc.client.GrpcClientRequest;
import io.vertx.grpc.server.GrpcServer;
import io.vertx.grpc.server.GrpcServerRequest;
import io.vertx.grpc.server.GrpcServerResponse;

@RunWith(VertxUnitRunner.class)
public class GrpcJWTTest {

  @Rule
  public final RunTestOnContext rule = new RunTestOnContext();

  private Vertx vertx;

  @Before
  public void setup() {
    vertx = Vertx.vertx();
  }

  @Test
  public void testJWTAuth(TestContext should) {
    final Async test = should.async();

    JWTAuthOptions authConfig = new JWTAuthOptions()
      .setKeyStore(new KeyStoreOptions()
        .setType("jceks")
        .setPath("keystore.jceks")
        .setPassword("secret"));

    JWTAuth authProvider = JWTAuth.create(vertx, authConfig);

    GrpcServer grpcServer = GrpcServer.server(vertx);
    
    HttpServerJWTHandler handler = HttpServerJWTHandler.create(authProvider);

    HttpServer server = vertx.createHttpServer().requestHandler(grpcServer);
    server.listen(0);
    int port = server.actualPort();
    String token = authProvider.generateToken(new JsonObject());

    // Create the method handler which does require authentication
    grpcServer.callHandler(GreeterGrpc.getSayHelloMethod(), request -> {
      User user = request.user();

      printHeaders(request);
      request.handler(hello -> {

        // log.info("Server got hello request with name {} from {}", hello.getName(), user.subject());
        GrpcServerResponse<HelloRequest, HelloReply> response = request.response();
        HelloReply reply = HelloReply.newBuilder()
          .setMessage("Reply with " + hello.getName() + " got user: " + user)
          .build();
        response.end(reply);
      });
    });

    GrpcClient client = GrpcClient.client(vertx);
    SocketAddress serverSocket = SocketAddress.inetSocketAddress(port, "localhost");

    client
      .request(serverSocket, GreeterGrpc.getSayHelloMethod()).compose(request -> {
        // TODO add this to client capabilities
        request.headers().add(HttpHeaders.AUTHORIZATION, new TokenCredentials(token).toHttpAuthorization());
        request.end(HelloRequest
          .newBuilder()
          .setName("Bob")
          .build());
        return request.response().compose(response -> response.last());
      }).onSuccess(reply -> {
        System.out.println("Received " + reply.getMessage());
        test.complete();
      });

    test.await();
  }

  private void printHeaders(GrpcServerRequest<HelloRequest, HelloReply> request) {
    for (String name : request.headers().names()) {
      System.out.println(name + " = " + request.headers().get(name));
    }
  }
}
