package io.obswebsocket.community.client.test;

import io.obswebsocket.community.client.OBSCommunicator;
import io.obswebsocket.community.client.OBSRemoteController;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.listener.lifecycle.controller.ControllerLifecycleListener;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
