package io.obswebsocket.community.client.test;

import static org.junit.jupiter.api.Assertions.fail;

import io.obswebsocket.community.client.OBSCommunicator;
import io.obswebsocket.community.client.OBSRemoteController;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;

public class OBSRemoteControllerUnsecuredIT {

  @Test
  void testConnectAndDisconnectToUnsecuredServer() throws Exception {

    AtomicReference<String> failReason = new AtomicReference<>();
    AtomicReference<Boolean> connectorReady = new AtomicReference<>(false);

    // Given we have a websocket client and annotated websocket communicator
    OBSCommunicator communicator = OBSCommunicator.builder()
        .password(null)
        // And given we have registered callbacks to disconnect once connected & identified
        .lifecycle()
        .onReady(() -> {
          System.out.println("(Test) Authenticated successfully");
          connectorReady.set(true);
        })
        .onHello((hello) -> {
          if (hello.getMessageData().getAuthentication() != null) {
            failReason.set("Authentication needs to be disabled for this test");
          }
        })
        .and()
        .build();
    OBSRemoteController remoteController = OBSRemoteController.builder()
        .communicator(communicator)
        .build();

    // When we connect to/from OBS
    remoteController.connect();
    Thread.sleep(1000);
    remoteController.disconnect();

    // Then there should be no errors
    if (failReason.get() != null) {
      fail(failReason.get());
    }
    // And the client should have been identified
    if (!connectorReady.get()) {
      fail("Did not successfully identify the communicator");
    }
  }

}
