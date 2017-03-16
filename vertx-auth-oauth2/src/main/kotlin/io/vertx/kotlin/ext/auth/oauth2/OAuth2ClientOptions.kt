package io.vertx.kotlin.ext.auth.oauth2

import io.vertx.ext.auth.oauth2.OAuth2ClientOptions
import io.vertx.core.http.Http2Settings
import io.vertx.core.http.HttpVersion
import io.vertx.core.net.JdkSSLEngineOptions
import io.vertx.core.net.JksOptions
import io.vertx.core.net.OpenSSLEngineOptions
import io.vertx.core.net.PemKeyCertOptions
import io.vertx.core.net.PemTrustOptions
import io.vertx.core.net.PfxOptions
import io.vertx.core.net.ProxyOptions

/**
 * A function providing a DSL for building [io.vertx.ext.auth.oauth2.OAuth2ClientOptions] objects.
 *
 * Options describing how an OAuth2  will make connections.
 *
 * @param alpnVersions 
 * @param authorizationPath 
 * @param clientID 
 * @param clientSecret 
 * @param clientSecretParameterName 
 * @param connectTimeout 
 * @param crlPaths 
 * @param crlValues 
 * @param defaultHost 
 * @param defaultPort 
 * @param enabledCipherSuites 
 * @param enabledSecureTransportProtocols 
 * @param extraParameters 
 * @param headers 
 * @param http2ClearTextUpgrade 
 * @param http2ConnectionWindowSize 
 * @param http2MaxPoolSize 
 * @param http2MultiplexingLimit 
 * @param idleTimeout 
 * @param initialSettings 
 * @param introspectionPath 
 * @param jdkSslEngineOptions 
 * @param jwtToken 
 * @param keepAlive 
 * @param keyStoreOptions 
 * @param localAddress 
 * @param logActivity 
 * @param logoutPath 
 * @param maxChunkSize 
 * @param maxHeaderSize 
 * @param maxInitialLineLength 
 * @param maxPoolSize 
 * @param maxRedirects 
 * @param maxWaitQueueSize 
 * @param maxWebsocketFrameSize 
 * @param maxWebsocketMessageSize 
 * @param metricsName 
 * @param openSslEngineOptions 
 * @param pemKeyCertOptions 
 * @param pemTrustOptions 
 * @param pfxKeyCertOptions 
 * @param pfxTrustOptions 
 * @param pipelining 
 * @param pipeliningLimit 
 * @param privateKey 
 * @param protocolVersion 
 * @param proxyOptions 
 * @param publicKey 
 * @param receiveBufferSize 
 * @param reuseAddress 
 * @param revocationPath 
 * @param scopeSeparator 
 * @param sendBufferSize 
 * @param sendUnmaskedFrames 
 * @param site 
 * @param soLinger 
 * @param ssl 
 * @param tcpKeepAlive 
 * @param tcpNoDelay 
 * @param tokenPath 
 * @param trafficClass 
 * @param trustAll 
 * @param trustStoreOptions 
 * @param tryUseCompression 
 * @param useAlpn 
 * @param useBasicAuthorizationHeader 
 * @param usePooledBuffers 
 * @param userAgent 
 * @param userInfoPath 
 * @param verifyHost 
 *
 * <p/>
 * NOTE: This function has been automatically generated from the [io.vertx.ext.auth.oauth2.OAuth2ClientOptions original] using Vert.x codegen.
 */
fun OAuth2ClientOptions(
  alpnVersions: Iterable<HttpVersion>? = null,
  authorizationPath: String? = null,
  clientID: String? = null,
  clientSecret: String? = null,
  clientSecretParameterName: String? = null,
  connectTimeout: Int? = null,
  crlPaths: Iterable<String>? = null,
  crlValues: Iterable<io.vertx.core.buffer.Buffer>? = null,
  defaultHost: String? = null,
  defaultPort: Int? = null,
  enabledCipherSuites: Iterable<String>? = null,
  enabledSecureTransportProtocols: Iterable<String>? = null,
  extraParameters: io.vertx.core.json.JsonObject? = null,
  headers: io.vertx.core.json.JsonObject? = null,
  http2ClearTextUpgrade: Boolean? = null,
  http2ConnectionWindowSize: Int? = null,
  http2MaxPoolSize: Int? = null,
  http2MultiplexingLimit: Int? = null,
  idleTimeout: Int? = null,
  initialSettings: io.vertx.core.http.Http2Settings? = null,
  introspectionPath: String? = null,
  jdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions? = null,
  jwtToken: Boolean? = null,
  keepAlive: Boolean? = null,
  keyStoreOptions: io.vertx.core.net.JksOptions? = null,
  localAddress: String? = null,
  logActivity: Boolean? = null,
  logoutPath: String? = null,
  maxChunkSize: Int? = null,
  maxHeaderSize: Int? = null,
  maxInitialLineLength: Int? = null,
  maxPoolSize: Int? = null,
  maxRedirects: Int? = null,
  maxWaitQueueSize: Int? = null,
  maxWebsocketFrameSize: Int? = null,
  maxWebsocketMessageSize: Int? = null,
  metricsName: String? = null,
  openSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions? = null,
  pemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions? = null,
  pemTrustOptions: io.vertx.core.net.PemTrustOptions? = null,
  pfxKeyCertOptions: io.vertx.core.net.PfxOptions? = null,
  pfxTrustOptions: io.vertx.core.net.PfxOptions? = null,
  pipelining: Boolean? = null,
  pipeliningLimit: Int? = null,
  privateKey: String? = null,
  protocolVersion: HttpVersion? = null,
  proxyOptions: io.vertx.core.net.ProxyOptions? = null,
  publicKey: String? = null,
  receiveBufferSize: Int? = null,
  reuseAddress: Boolean? = null,
  revocationPath: String? = null,
  scopeSeparator: String? = null,
  sendBufferSize: Int? = null,
  sendUnmaskedFrames: Boolean? = null,
  site: String? = null,
  soLinger: Int? = null,
  ssl: Boolean? = null,
  tcpKeepAlive: Boolean? = null,
  tcpNoDelay: Boolean? = null,
  tokenPath: String? = null,
  trafficClass: Int? = null,
  trustAll: Boolean? = null,
  trustStoreOptions: io.vertx.core.net.JksOptions? = null,
  tryUseCompression: Boolean? = null,
  useAlpn: Boolean? = null,
  useBasicAuthorizationHeader: Boolean? = null,
  usePooledBuffers: Boolean? = null,
  userAgent: String? = null,
  userInfoPath: String? = null,
  verifyHost: Boolean? = null): OAuth2ClientOptions = io.vertx.ext.auth.oauth2.OAuth2ClientOptions().apply {

  if (alpnVersions != null) {
    this.setAlpnVersions(alpnVersions.toList())
  }
  if (authorizationPath != null) {
    this.setAuthorizationPath(authorizationPath)
  }
  if (clientID != null) {
    this.setClientID(clientID)
  }
  if (clientSecret != null) {
    this.setClientSecret(clientSecret)
  }
  if (clientSecretParameterName != null) {
    this.setClientSecretParameterName(clientSecretParameterName)
  }
  if (connectTimeout != null) {
    this.setConnectTimeout(connectTimeout)
  }
  if (crlPaths != null) {
    for (item in crlPaths) {
      this.addCrlPath(item)
    }
  }
  if (crlValues != null) {
    for (item in crlValues) {
      this.addCrlValue(item)
    }
  }
  if (defaultHost != null) {
    this.setDefaultHost(defaultHost)
  }
  if (defaultPort != null) {
    this.setDefaultPort(defaultPort)
  }
  if (enabledCipherSuites != null) {
    for (item in enabledCipherSuites) {
      this.addEnabledCipherSuite(item)
    }
  }
  if (enabledSecureTransportProtocols != null) {
    for (item in enabledSecureTransportProtocols) {
      this.addEnabledSecureTransportProtocol(item)
    }
  }
  if (extraParameters != null) {
    this.setExtraParameters(extraParameters)
  }
  if (headers != null) {
    this.setHeaders(headers)
  }
  if (http2ClearTextUpgrade != null) {
    this.setHttp2ClearTextUpgrade(http2ClearTextUpgrade)
  }
  if (http2ConnectionWindowSize != null) {
    this.setHttp2ConnectionWindowSize(http2ConnectionWindowSize)
  }
  if (http2MaxPoolSize != null) {
    this.setHttp2MaxPoolSize(http2MaxPoolSize)
  }
  if (http2MultiplexingLimit != null) {
    this.setHttp2MultiplexingLimit(http2MultiplexingLimit)
  }
  if (idleTimeout != null) {
    this.setIdleTimeout(idleTimeout)
  }
  if (initialSettings != null) {
    this.setInitialSettings(initialSettings)
  }
  if (introspectionPath != null) {
    this.setIntrospectionPath(introspectionPath)
  }
  if (jdkSslEngineOptions != null) {
    this.setJdkSslEngineOptions(jdkSslEngineOptions)
  }
  if (jwtToken != null) {
    this.setJwtToken(jwtToken)
  }
  if (keepAlive != null) {
    this.setKeepAlive(keepAlive)
  }
  if (keyStoreOptions != null) {
    this.setKeyStoreOptions(keyStoreOptions)
  }
  if (localAddress != null) {
    this.setLocalAddress(localAddress)
  }
  if (logActivity != null) {
    this.setLogActivity(logActivity)
  }
  if (logoutPath != null) {
    this.setLogoutPath(logoutPath)
  }
  if (maxChunkSize != null) {
    this.setMaxChunkSize(maxChunkSize)
  }
  if (maxHeaderSize != null) {
    this.setMaxHeaderSize(maxHeaderSize)
  }
  if (maxInitialLineLength != null) {
    this.setMaxInitialLineLength(maxInitialLineLength)
  }
  if (maxPoolSize != null) {
    this.setMaxPoolSize(maxPoolSize)
  }
  if (maxRedirects != null) {
    this.setMaxRedirects(maxRedirects)
  }
  if (maxWaitQueueSize != null) {
    this.setMaxWaitQueueSize(maxWaitQueueSize)
  }
  if (maxWebsocketFrameSize != null) {
    this.setMaxWebsocketFrameSize(maxWebsocketFrameSize)
  }
  if (maxWebsocketMessageSize != null) {
    this.setMaxWebsocketMessageSize(maxWebsocketMessageSize)
  }
  if (metricsName != null) {
    this.setMetricsName(metricsName)
  }
  if (openSslEngineOptions != null) {
    this.setOpenSslEngineOptions(openSslEngineOptions)
  }
  if (pemKeyCertOptions != null) {
    this.setPemKeyCertOptions(pemKeyCertOptions)
  }
  if (pemTrustOptions != null) {
    this.setPemTrustOptions(pemTrustOptions)
  }
  if (pfxKeyCertOptions != null) {
    this.setPfxKeyCertOptions(pfxKeyCertOptions)
  }
  if (pfxTrustOptions != null) {
    this.setPfxTrustOptions(pfxTrustOptions)
  }
  if (pipelining != null) {
    this.setPipelining(pipelining)
  }
  if (pipeliningLimit != null) {
    this.setPipeliningLimit(pipeliningLimit)
  }
  if (privateKey != null) {
    this.setPrivateKey(privateKey)
  }
  if (protocolVersion != null) {
    this.setProtocolVersion(protocolVersion)
  }
  if (proxyOptions != null) {
    this.setProxyOptions(proxyOptions)
  }
  if (publicKey != null) {
    this.setPublicKey(publicKey)
  }
  if (receiveBufferSize != null) {
    this.setReceiveBufferSize(receiveBufferSize)
  }
  if (reuseAddress != null) {
    this.setReuseAddress(reuseAddress)
  }
  if (revocationPath != null) {
    this.setRevocationPath(revocationPath)
  }
  if (scopeSeparator != null) {
    this.setScopeSeparator(scopeSeparator)
  }
  if (sendBufferSize != null) {
    this.setSendBufferSize(sendBufferSize)
  }
  if (sendUnmaskedFrames != null) {
    this.setSendUnmaskedFrames(sendUnmaskedFrames)
  }
  if (site != null) {
    this.setSite(site)
  }
  if (soLinger != null) {
    this.setSoLinger(soLinger)
  }
  if (ssl != null) {
    this.setSsl(ssl)
  }
  if (tcpKeepAlive != null) {
    this.setTcpKeepAlive(tcpKeepAlive)
  }
  if (tcpNoDelay != null) {
    this.setTcpNoDelay(tcpNoDelay)
  }
  if (tokenPath != null) {
    this.setTokenPath(tokenPath)
  }
  if (trafficClass != null) {
    this.setTrafficClass(trafficClass)
  }
  if (trustAll != null) {
    this.setTrustAll(trustAll)
  }
  if (trustStoreOptions != null) {
    this.setTrustStoreOptions(trustStoreOptions)
  }
  if (tryUseCompression != null) {
    this.setTryUseCompression(tryUseCompression)
  }
  if (useAlpn != null) {
    this.setUseAlpn(useAlpn)
  }
  if (useBasicAuthorizationHeader != null) {
    this.setUseBasicAuthorizationHeader(useBasicAuthorizationHeader)
  }
  if (usePooledBuffers != null) {
    this.setUsePooledBuffers(usePooledBuffers)
  }
  if (userAgent != null) {
    this.setUserAgent(userAgent)
  }
  if (userInfoPath != null) {
    this.setUserInfoPath(userInfoPath)
  }
  if (verifyHost != null) {
    this.setVerifyHost(verifyHost)
  }
}
