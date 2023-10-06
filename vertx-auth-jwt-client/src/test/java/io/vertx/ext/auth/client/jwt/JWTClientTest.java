package io.vertx.ext.auth.client.jwt;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpClientResponse;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.KeyStoreOptions;
import io.vertx.ext.auth.authentication.TokenCredentials;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTAuthOptions;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.RunTestOnContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.JWTAuthHandler;

@RunWith(VertxUnitRunner.class)
public class JWTClientTest {

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

    Router router = Router.router(vertx);

    JWTAuthOptions authConfig = new JWTAuthOptions()
      .setKeyStore(new KeyStoreOptions()
        .setType("jceks")
        .setPath("keystore.jceks")
        .setPassword("secret"));

    JWTAuth authProvider = JWTAuth.create(vertx, authConfig);

    router.route("/protected/*").handler(JWTAuthHandler.create(authProvider));

    router.route("/protected/somepage").handler(rc -> {
      rc.response().end("Hello World");
    });

    HttpServer server = vertx.createHttpServer().requestHandler(router::handle);
    server.listen(0);
    int port = server.actualPort();

    HttpClientOptions clientOptions = new HttpClientOptions().setDefaultPort(port);
    Future<HttpClientRequest> requestFuture = vertx.createHttpClient(clientOptions)
      .request(HttpMethod.GET, "localhost", "/protected/somepage");
    requestFuture.onFailure(should::fail);
    TokenCredentials credentials = new TokenCredentials();
    credentials.setToken(authProvider.generateToken(new JsonObject()));
    requestFuture.map(req -> JWTClientHandler.jwtHandler(req, credentials)).onComplete(res -> {
      if (res.failed()) {
        should.fail(res.cause());
      } else {
        HttpClientRequest request = res.result();
        request.send().onComplete(resp -> {
          if (resp.failed()) {
            should.fail(resp.cause());
          } else {
            HttpClientResponse response = resp.result();
            should.assertEquals(200, response.statusCode());
            response.bodyHandler(buff -> {
              System.out.println(buff.toString());
              test.complete();
            });
          }
        });
      }
    });
  }


}
