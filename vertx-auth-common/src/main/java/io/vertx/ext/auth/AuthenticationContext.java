package io.vertx.ext.auth;

import io.vertx.codegen.annotations.CacheReturn;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;

/**
 * Represents the context for the handling of a authentication processes in Vert.x-Auth.
 * 
 * <p>
 * The context provides access to the {@link HttpServerRequest} and {@link HttpServerResponse} and 
 * allows you to access the {@link io.vertx.ext.auth.User}.
 *
 * @author <a href="http://www.jotschi.de">Johannes Schüth</a>
 */
@VertxGen
public interface AuthenticationContext {

  /**
   * @return the HTTP request object
   */
  @CacheReturn
  HttpServerRequest request();

  /**
   * @return the HTTP response object
   */
  @CacheReturn
  HttpServerResponse response();

  /**
   * Control the user associated with this request. The user context allows accessing the security user object as well
   * as perform authentication refreshes, logout and other operations.
   * @return the user context
   */
  UserContext user();

  /**
   * Fail the context with the specified status code.
   * <p>
   * This will cause the router to route the context to any matching failure handlers for the request. If no failure handlers
   * match It will trigger the error handler matching the status code. You can define such error handler with
   * {@link Router#errorHandler(int, Handler)}. If no error handler is not defined, It will send a default failure response with provided status code.
   *
   * @param statusCode  the HTTP status code
   */
  void fail(int statusCode);

  /**
   * Fail the context with the specified throwable and 500 status code.
   * <p>
   * This will cause the router to route the context to any matching failure handlers for the request. If no failure handlers
   * match It will trigger the error handler matching the status code. You can define such error handler with
   * {@link Router#errorHandler(int, Handler)}. If no error handler is not defined, It will send a default failure response with 500 status code.
   *
   * @param throwable  a throwable representing the failure
   */
  void fail(Throwable throwable);

  /**
   * Fail the context with the specified throwable and the specified the status code.
   * <p>
   * This will cause the router to route the context to any matching failure handlers for the request. If no failure handlers
   * match It will trigger the error handler matching the status code. You can define such error handler with
   * {@link Router#errorHandler(int, Handler)}. If no error handler is not defined, It will send a default failure response with provided status code.
   *
   * @param statusCode the HTTP status code
   * @param throwable a throwable representing the failure
   */
  void fail(int statusCode, Throwable throwable);

  default void onSuccess(User authenticated) {
    // NOOP
  }

  // TODO rename method?
  void next();

  
}
