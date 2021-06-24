package io.obswebsocket.community.authenticator;

public interface Authenticator {
  String computeAuthentication(String salt, String challenge);
}
