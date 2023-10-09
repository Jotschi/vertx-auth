package io.vertx.ext.grpc.handler;

import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.grpc.handler.impl.HttpServerJWTHandlerImpl;

public interface HttpServerJWTHandler {

  static HttpServerJWTHandler create(JWTAuth authProvider) {
    return new HttpServerJWTHandlerImpl(authProvider);
  }

}
