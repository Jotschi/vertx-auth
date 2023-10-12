package io.vertx.ext.grpc.handler.impl;

import io.vertx.core.Future;
import io.vertx.ext.auth.AuthenticationContext;
import io.vertx.ext.auth.User;
import io.vertx.ext.auth.UserContext;
import io.vertx.ext.auth.UserContextInternal;

public class UserContextImpl implements UserContextInternal {

  private User user;
  private AuthenticationContext ctx;

  public UserContextImpl(AuthenticationContext ctx) {
    this.ctx = ctx;
  }

  @Override
  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public User get() {
    return user;
  }

  @Override
  public UserContext loginHint(String loginHint) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Future<Void> refresh() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Future<Void> refresh(String redirectUri) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Future<Void> impersonate() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Future<Void> impersonate(String redirectUri) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Future<Void> restore() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Future<Void> restore(String redirectUri) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Future<Void> logout(String redirectUri) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Future<Void> logout() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void clear() {
    user = null;
  }

}
