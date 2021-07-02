package io.obswebsocket.community.client.test;

import static org.assertj.core.api.Assertions.assertThat;

import io.obswebsocket.community.client.OBSCommunicator;
import io.obswebsocket.community.client.OBSRemoteController;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class UnreachableObsIT {

  @Test
  void controllerDisconnectsWhenObsCannotBeContacted_shortTimeout() throws Exception {
    AtomicReference<ReasonThrowable> reasonThrowableReference = new AtomicReference<>();

    // Given we have a remote configured to timeout after 1 second
    // And on a port where OBS isn't listening
    OBSRemoteController remoteController = OBSRemoteController.builder()
        .communicator(OBSCommunicator.builder().build())
        .port(4545)
        .connectionTimeout(1)
        .lifecycle()
        .onControllerError((controller, reasonThrowable) -> {
          reasonThrowableReference.set(reasonThrowable);
        })
        .and()
        .build();

    // When we try to connect to OBS
    remoteController.connect();

    // Then the communicator closes the connection
    // Depending on the OS, this can be a Timeout or ConnectionRefused, so all we care about is
    // that the exception is provided for inspection.
    assertThat(reasonThrowableReference.get().getThrowable()).isNotNull();
    assertThat(reasonThrowableReference.get().getReason())
        .containsIgnoringCase("Could not contact OBS");

  }

  @Timeout(10)
  @Test
  void controllerDisconnectsWhenObsCannotBeContacted_longTimeout() throws Exception {
    AtomicReference<ReasonThrowable> reasonThrowableReference = new AtomicReference<>();

    // Given we have a remote configured to timeout after a long time
    // And on a port where OBS isn't listening
    OBSRemoteController remoteController = OBSRemoteController.builder()
        .communicator(OBSCommunicator.builder().build())
        .port(4545)
        .connectionTimeout(300)
        .lifecycle()
        .onControllerError((controller, reasonThrowable) -> {
          reasonThrowableReference.set(reasonThrowable);
        })
        .and()
        .build();

    // When we try to connect to OBS
    remoteController.connect();

    // Then the an internal timeout in the WebSocketClient closes the connection
    // before communicator closes the connection before our configured timeout
    // (if it takes longer than the timeout on this test, then this indicates a change to the client)
    assertThat(reasonThrowableReference.get().getThrowable()).isNotNull();
    assertThat(reasonThrowableReference.get().getReason())
        .containsIgnoringCase("Could not contact OBS");

  }

  @Test
  void unreachableHost() throws Exception {
    AtomicReference<ReasonThrowable> reasonThrowableReference = new AtomicReference<>();

    // Given we have a remote configured to timeout after 1 second
    // And on a host where OBS isn't listening
    OBSRemoteController remoteController = OBSRemoteController.builder()
        .communicator(OBSCommunicator.builder().build())
        .host(UUID.randomUUID()
            .toString()) // UUID is random and valid because it contains - instead of _
        .connectionTimeout(1)
        .lifecycle()
        .onControllerError((controller, reasonThrowable) -> {
          reasonThrowableReference.set(reasonThrowable);
        })
        .and()
        .build();

    // When we try to connect to OBS
    remoteController.connect();

    // Then the communicator closes the connection
    // Depending on the OS, this can be a Timeout or ConnectionRefused, so all we care about is
    // that the exception is provided for inspection.
    assertThat(reasonThrowableReference.get().getThrowable()).isNotNull();
    assertThat(reasonThrowableReference.get().getReason())
        .containsIgnoringCase("Could not contact OBS");

  }

}
