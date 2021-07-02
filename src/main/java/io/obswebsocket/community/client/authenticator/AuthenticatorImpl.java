package io.obswebsocket.community.client.authenticator;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AuthenticatorImpl implements Authenticator {

  private final String password;

  public AuthenticatorImpl(String password) {
    if (password == null) {
      throw new IllegalArgumentException("Password is required");
    }
    this.password = password;
  }

  @Override
  public String computeAuthentication(String salt, String challenge) {
    // Sanitize
    if (salt == null || challenge == null) {
      throw new IllegalArgumentException("Password, salt, and challenge are required");
    }

    // Compute
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");

      String secretString = this.password + salt;
      byte[] secretHash = digest.digest(secretString.getBytes(StandardCharsets.UTF_8));
      String encodedSecret = Base64.getEncoder().encodeToString(secretHash);

      String resultString = encodedSecret + challenge;
      byte[] resultHash = digest.digest(resultString.getBytes(StandardCharsets.UTF_8));

      return Base64.getEncoder().encodeToString(resultHash);
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalStateException("Could not find expected message digest to compute auth", e);
    }
  }

}
