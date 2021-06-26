package io.obswebsocket.community.client.test.auth;

import io.obswebsocket.community.client.authenticator.Authenticator;
import io.obswebsocket.community.client.authenticator.AuthenticatorImpl;
import io.obswebsocket.community.client.authenticator.NoOpAuthenticator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AuthChallengeTest {

  @Test
  void computeExpected() {

    // Given
    String password = "supersecretpassword";
    String challenge = "+IxH4CnCiqpX1rM9scsNynZzbOe4KhDeYcTNS3PDaeY=";
    String salt = "lM1GncleQOaCu9lT1yeUZhFYnqhsLLP1G5lAGo3ixaI=";

    // When computed
    Authenticator authenticator = new AuthenticatorImpl(password);
    String auth = authenticator.computeAuthentication(challenge, salt);

    // It matches as expected
    assertThat(auth).isEqualTo("eDDjN+A7zLjsJVZvgOUIiJiQQ7fol1rU29omxFB89+U=");

  }

  @Test
  void invalidArgs() {

    assertThatThrownBy(() -> {
      new AuthenticatorImpl(null);
    }).isInstanceOf(IllegalArgumentException.class);

    Authenticator authenticator = new AuthenticatorImpl("somepass");
    assertThatThrownBy(() -> {
      authenticator.computeAuthentication(null, "bar");
    }).isInstanceOf(IllegalArgumentException.class);

    assertThatThrownBy(() -> {
      authenticator.computeAuthentication("foo", null);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void noOpAuthenticatorReturnsNull() {
    Authenticator authenticator = new NoOpAuthenticator();
    assertThat(authenticator.computeAuthentication("salt", "challenge")).isNull();
    assertThat(authenticator.computeAuthentication(null, "challenge")).isNull();
    assertThat(authenticator.computeAuthentication("salt", null)).isNull();
  }
}
