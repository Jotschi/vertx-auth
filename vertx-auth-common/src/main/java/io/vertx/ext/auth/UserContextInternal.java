package io.vertx.ext.auth;

public interface UserContextInternal extends UserContext {

  /**
   * Set the user. Usually used by auth handlers to inject a User. You will not normally call this method.
   *
   * @param user  the user
   */
  void setUser(User user);
}
