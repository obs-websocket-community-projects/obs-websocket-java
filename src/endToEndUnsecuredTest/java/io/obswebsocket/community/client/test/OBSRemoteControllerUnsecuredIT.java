package io.obswebsocket.community.client.test;

import io.obswebsocket.community.client.OBSCommunicator;
import io.obswebsocket.community.client.OBSRemoteController;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class OBSRemoteControllerUnsecuredIT {

    @Test
    void testConnectAndDisconnectToUnsecuredServer() throws Exception {

        AtomicReference<String> failReason = new AtomicReference<>();
        AtomicReference<Boolean> connectorIdentified = new AtomicReference<>(false);

        // Given we have a websocket client and annotated websocket communicator
        OBSCommunicator communicator = OBSCommunicator.builder()
          .password(null)
          // And given we have registered callbacks to disconnect once connected & identified
          .lifecycle()
          .onIdentified((comm,identified) -> {
              System.out.println("(Test) Authenticated successfully");
              connectorIdentified.set(true);
          })
          .onHello((comm, hello) -> {
              if(hello.getAuthentication() != null) {
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
        if (!connectorIdentified.get()) {
            fail("Did not successfully identify the communicator");
        }
    }

}
