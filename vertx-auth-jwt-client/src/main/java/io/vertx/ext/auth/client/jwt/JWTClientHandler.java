package io.vertx.ext.auth.client.jwt;

import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpHeaders;
import io.vertx.ext.auth.authentication.TokenCredentials;

public class JWTClientHandler {

  /**
   * Add the credentials to the given request.
   * 
   * @param request
   * @param credentials
   * @return
   */
  public static HttpClientRequest jwtHandler(HttpClientRequest request, TokenCredentials credentials) {
    return request.putHeader(HttpHeaders.AUTHORIZATION, credentials.toHttpAuthorization());
  }
}
