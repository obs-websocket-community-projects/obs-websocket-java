package io.obswebsocket.community.client.authenticator;

public interface Authenticator {

  String computeAuthentication(String salt, String challenge);
}
