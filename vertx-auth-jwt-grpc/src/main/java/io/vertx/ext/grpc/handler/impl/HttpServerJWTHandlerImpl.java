package io.vertx.ext.grpc.handler.impl;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.auth.AuthenticationContext;
import io.vertx.ext.auth.audit.SecurityAudit;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.handler.AbstractHttpServerJWTHandler;
import io.vertx.ext.grpc.handler.HttpServerJWTHandler;

public class HttpServerJWTHandlerImpl extends AbstractHttpServerJWTHandler<AuthenticationContext> implements HttpServerJWTHandler {

  private Handler<HttpServerRequest> postAuthHandler;

  public HttpServerJWTHandlerImpl(JWTAuth authProvider, Handler<HttpServerRequest> postAuthHandler) {
    this(authProvider, null, postAuthHandler);
  }

  public HttpServerJWTHandlerImpl(JWTAuth authProvider, String realm, Handler<HttpServerRequest> postAuthHandler) {
    super(authProvider, realm);
    this.postAuthHandler = postAuthHandler;
  }

  @Override
  public void postAuthentication(AuthenticationContext ctx) {
    try {
      postAuthHandler.handle(ctx.request());
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  protected SecurityAudit invokeAudit(String token, AuthenticationContext context) {
    return null;
  }

}
