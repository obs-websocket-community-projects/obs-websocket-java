package net.twasi.obsremotejava.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import net.twasi.obsremotejava.message.authentication.Authenticator;
import org.junit.jupiter.api.Test;

public class AuthChallengeTest {

  Authenticator authenticator = new Authenticator();

  @Test
  void computeExpected() {

    // Given
    String password = "supersecretpassword";
    String challenge = "+IxH4CnCiqpX1rM9scsNynZzbOe4KhDeYcTNS3PDaeY=";
    String salt = "lM1GncleQOaCu9lT1yeUZhFYnqhsLLP1G5lAGo3ixaI=";

    // When computed
    String auth = authenticator.computeAuthentication(password, challenge, salt);

    // It matches as expected
    assertThat(auth).isEqualTo("eDDjN+A7zLjsJVZvgOUIiJiQQ7fol1rU29omxFB89+U=");

  }

  @Test
  void invalidArgs() {
    assertThatThrownBy(() -> {
      authenticator.computeAuthentication(null, "foo", "bar");
    }).isInstanceOf(IllegalArgumentException.class);

    assertThatThrownBy(() -> {
      authenticator.computeAuthentication("password", null, "bar");
    }).isInstanceOf(IllegalArgumentException.class);

    assertThatThrownBy(() -> {
      authenticator.computeAuthentication("password", "foo", null);
    }).isInstanceOf(IllegalArgumentException.class);
  }
}
