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

}
