package net.twasi.obsremotejava;

public interface Authenticator {
  String computeAuthentication(String salt, String challenge);
}
