package io.vertx.ext.auth.jwt.handler;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import io.vertx.core.Future;
import io.vertx.ext.auth.AuthenticationContext;
import io.vertx.ext.auth.HttpException;
import io.vertx.ext.auth.User;
import io.vertx.ext.auth.audit.Marker;
import io.vertx.ext.auth.audit.SecurityAudit;
import io.vertx.ext.auth.authentication.TokenCredentials;
import io.vertx.ext.auth.handler.impl.HTTPAuthorizationHandler;
import io.vertx.ext.auth.handler.impl.HTTPAuthorizationHandler.Type;
import io.vertx.ext.auth.jwt.JWTAuth;

public abstract class AbstractHttpServerJWTHandler<C extends AuthenticationContext> extends HTTPAuthorizationHandler<JWTAuth, C> {

  private final List<String> scopes;
  private String delimiter;

  public AbstractHttpServerJWTHandler(JWTAuth authProvider, String realm) {
    super(authProvider, Type.BEARER, realm);
    scopes = Collections.emptyList();
    this.delimiter = " ";
  }

  public AbstractHttpServerJWTHandler(JWTAuth authProvider, Type type, String realm) {
    super(authProvider, type, realm);
    scopes = Collections.emptyList();
    this.delimiter = " ";
  }

  private AbstractHttpServerJWTHandler(AbstractHttpServerJWTHandler<C> base, List<String> scopes, String delimiter) {
    super(base.authProvider, Type.BEARER, base.realm);
    Objects.requireNonNull(scopes, "scopes cannot be null");
    this.scopes = scopes;
    Objects.requireNonNull(delimiter, "delimiter cannot be null");
    this.delimiter = delimiter;
  }

  @Override
  public Future<User> authenticate(AuthenticationContext context) {

    return parseAuthorization(context)
      .compose(token -> {
        int segments = 0;
        for (int i = 0; i < token.length(); i++) {
          char c = token.charAt(i);
          if (c == '.') {
            if (++segments == 3) {
              return Future.failedFuture(new HttpException(400, "Too many segments in token"));
            }
            continue;
          }
          if (Character.isLetterOrDigit(c) || c == '-' || c == '_') {
            continue;
          }
          // invalid character
          return Future.failedFuture(new HttpException(400, "Invalid character in token: " + (int) c));
        }

        SecurityAudit audit = invokeAudit(token, context);

        Future<User> fut = authProvider
          .authenticate(new TokenCredentials(token));
          
        if (audit!=null)  {
          fut = fut.andThen(op -> audit.audit(Marker.AUTHENTICATION, op.succeeded()));
        }
          
        return fut.recover(err -> Future.failedFuture(new HttpException(401, err)));
      });
  }

  protected abstract SecurityAudit invokeAudit(String token, AuthenticationContext context);

}
