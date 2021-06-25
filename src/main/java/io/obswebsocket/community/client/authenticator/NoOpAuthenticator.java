package io.obswebsocket.community.client.authenticator;

public class NoOpAuthenticator implements Authenticator {

  @Override
  public String computeAuthentication(String salt, String challenge) {
    return null;
  }
}
