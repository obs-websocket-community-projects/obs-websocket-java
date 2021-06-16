package net.twasi.obsremotejava.authenticator;

public interface Authenticator {
  String computeAuthentication(String salt, String challenge);
}
