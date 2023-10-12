package io.vertx.ext.grpc.handler;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.grpc.handler.impl.HttpServerJWTHandlerImpl;

public interface HttpServerJWTHandler extends AuthenticationHandler {

  static HttpServerJWTHandler create(JWTAuth authProvider, Handler<HttpServerRequest> postAuthHandler) {
    return new HttpServerJWTHandlerImpl(authProvider, postAuthHandler);
  }

}
