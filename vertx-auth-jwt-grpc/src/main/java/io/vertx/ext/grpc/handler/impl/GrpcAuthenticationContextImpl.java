package io.vertx.ext.grpc.handler.impl;

import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.auth.AuthenticationContext;
import io.vertx.ext.auth.UserContext;

public class GrpcAuthenticationContextImpl implements AuthenticationContext {

  private HttpServerRequest request;
  private UserContext identity;

  public GrpcAuthenticationContextImpl(HttpServerRequest request) {
    this.request = request;
  }

  @Override
  public HttpServerRequest request() {
    return request;
  }

  @Override
  public HttpServerResponse response() {
    return request.response();
  }

  @Override
  public UserContext user() {
    if (identity == null) {
      identity = new UserContextImpl(this);
    }
    return identity;
  }

  @Override
  public void fail(int statusCode) {
    // TODO Auto-generated method stub

  }

  @Override
  public void fail(Throwable throwable) {
    // TODO Auto-generated method stub

  }

  @Override
  public void fail(int statusCode, Throwable throwable) {
    // TODO Auto-generated method stub
  }

  @Override
  public void next() {
    // NOOP
  }

}
