package net.twasi.obsremotejava;

public class NoOpAuthenticator implements Authenticator {

  @Override
  public String computeAuthentication(String salt, String challenge) {
    return null;
  }
}
