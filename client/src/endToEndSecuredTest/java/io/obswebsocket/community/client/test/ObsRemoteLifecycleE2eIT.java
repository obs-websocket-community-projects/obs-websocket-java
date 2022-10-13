package io.obswebsocket.community.client.test;

import static org.assertj.core.api.Assertions.assertThat;

import io.obswebsocket.community.client.OBSCommunicator;
import io.obswebsocket.community.client.OBSRemoteController;
import io.obswebsocket.community.client.WebSocketCloseCode;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jetty.websocket.api.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/**
 * This could be in the 'unsecured' tests category, but atm we cannot yet automate E2E tests with
 * auth disabled. So, I'm putting this test here for now so it is run in CI/CD and gives us that
 * coverage.
 */
@Timeout(5)
public class ObsRemoteLifecycleE2eIT {

  private final String PASSWORD = "password";

  @Test
  void communicatorClosesConnectionOnError() throws Exception {

    AtomicReference<String> failReason = new AtomicReference<>();
    AtomicReference<WebSocketCloseCode> webSocketCloseCodeAtomicReference = new AtomicReference<>();
    AtomicReference<Session> sessionAtomicReference = new AtomicReference<>();

    // Given we have a remote that connects successfully
    OBSCommunicator communicator = OBSCommunicator.builder()
        .password(PASSWORD)
        // Given we register a callback on close
        .lifecycle()
        .onConnect((sessionAtomicReference::set))
        .onClose(webSocketCloseCodeAtomicReference::set)
        .onHello((hello) -> {
          if (hello.getMessageData().getAuthentication() == null) {
            failReason.set("Authentication wasn't enabled");
          }
        })
        .and()
        .build();
    OBSRemoteController remoteController = OBSRemoteController.builder()
        .communicator(communicator)
        .build();

    // And we connect to OBS
    remoteController.connect();
    // And we connected
    if (failReason.get() != null) {
      Assertions.fail(failReason.get());
    }

    // When an error occurs
    assertThat(sessionAtomicReference.get()).isNotNull();
    communicator.onError(sessionAtomicReference.get(), new Exception("Some Exception"));

    // And we wait reasonably
    Thread.sleep(1000);

    // Then the communicator closes the connection
    assertThat(webSocketCloseCodeAtomicReference.get()).isEqualTo(WebSocketCloseCode.UnknownReason);

  }

}
