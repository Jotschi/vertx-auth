/********************************************************************************
 * Copyright (c) 2019 Stephane Bastian
 *
 * This program and the accompanying materials are made available under the 2
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 3
 *
 * Contributors: 4
 *   Stephane Bastian - initial API and implementation
 ********************************************************************************/
package io.vertx.ext.auth.authorization;

import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.Future;
import io.vertx.ext.auth.User;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The role of an AuthorizationProvider is to return a set of Authorization.
 * Note that each AuthorizationProvider must provide its own unique Id
 *
 * @author stephane bastian
 */
@VertxGen(concrete = false)
public interface AuthorizationProvider {

  /**
   * returns the id of the authorization provider
   *
   * @return
   */
  String getId();

  /**
   * Updates the user with the set of authorizations.
   *
   * @param user user to lookup and update.
   * @return Future void to signal end of asynchronous call.
   */
  Future<Void> getAuthorizations(User user);
}
