package io.obswebsocket.community.client.test;

import io.obswebsocket.community.client.OBSRemoteController;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OBSRemoteControllerTest {

  @Test
  void timeoutMustBePositive() {
    assertThatThrownBy(() -> {
      OBSRemoteController.builder().connectionTimeout(-1).build();
    }).isInstanceOf(IllegalArgumentException.class)
    .hasMessage("Connection timeout must be greater than zero");
  }

  @Test
  void invalidHost() {
    assertThatThrownBy(() -> {
      OBSRemoteController.builder().host("some_/invalid_ho\\st").build();
    }).isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Host or Port are invalid");
  }
}
