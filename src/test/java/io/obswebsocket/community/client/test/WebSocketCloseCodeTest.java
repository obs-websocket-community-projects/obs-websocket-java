package io.obswebsocket.community.client.test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import io.obswebsocket.community.client.WebSocketCloseCode;
import org.junit.jupiter.api.Test;

public class WebSocketCloseCodeTest {

  @Test
  void fromValidCode() {
    WebSocketCloseCode known = WebSocketCloseCode.AuthenticationFailed;
    assertThat(WebSocketCloseCode.fromCode(known.getCode())).isEqualTo(known);
  }

  @Test
  void fromInvalidCode() {
    assertThatThrownBy(() -> {
      WebSocketCloseCode.fromCode(69696969);
    }).isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Code is invalid");
  }

}
