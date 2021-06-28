package io.obswebsocket.community.client.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import io.obswebsocket.community.client.OBSCommunicator;
import io.obswebsocket.community.client.OBSRemoteController;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.listener.lifecycle.communicator.CommunicatorLifecycleListener.CodeReason;
import java.net.ConnectException;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jetty.websocket.api.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/**
 * This could be in the 'unsecured' tests category, but atm we cannot yet automate
 * E2E tests with auth disabled. So, I'm putting this test here for now so it is run
 * in CI/CD and gives us that coverage.
 */
@Timeout(5)
public class ObsRemoteLifecycleE2eIT {

  private final String PASSWORD = "password";

  @Test
  void communicatorClosesConnectionOnError() throws Exception {

    AtomicReference<String> failReason = new AtomicReference<>();
    AtomicReference<CodeReason> closeCodeReason = new AtomicReference<>();
    AtomicReference<Session> sessionAtomicReference = new AtomicReference<>();

    // Given we have a remote that connects successfully
    OBSCommunicator communicator = OBSCommunicator.builder()
      .password(PASSWORD)
      // Given we register a callback on close
      .lifecycle()
        .onConnect(((comm, session) -> sessionAtomicReference.set(session)))
        .onClose((comm, codeReason) -> {
          closeCodeReason.set(codeReason);
        })
        .onHello((comm, hello) -> {
          if(hello.getAuthentication() == null) {
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
    if(failReason.get() != null) {
      Assertions.fail(failReason.get());
    }

    // When an error occurs
    assertThat(sessionAtomicReference.get()).isNotNull();
    communicator.onError(sessionAtomicReference.get(), new Exception("Some Exception"));

    // And we wait reasonably
    Thread.sleep(1000);

    // Then the communicator closes the connection
    assertThat(closeCodeReason.get().getCode()).isEqualTo(4000);
    assertThat(closeCodeReason.get().getReason()).containsIgnoringCase("Some Exception");

  }

  @Timeout(3)
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
        .onError((controller, reasonThrowable) -> {
          reasonThrowableReference.set(reasonThrowable);
        })
        .and()
      .build();

    // When we try to connect to OBS
    remoteController.connect();

    // Then the communicator closes the connection
    assertThat(reasonThrowableReference.get().getThrowable()).isNull(); // TimeoutException has no cause
    assertThat(reasonThrowableReference.get().getReason()).containsIgnoringCase("Could not contact OBS");

  }

  @Timeout(6)
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
      .onError((controller, reasonThrowable) -> {
        reasonThrowableReference.set(reasonThrowable);
      })
      .and()
      .build();

    // When we try to connect to OBS
    remoteController.connect();

    // Then the an internal timeout in the WebSocketClient closes the connection
    // before communicator closes the connection before our configured timeout
    // (if it takes longer than the timeout on this test, then this indicates a change to the client)
    assertThat(reasonThrowableReference.get().getThrowable()).isNotNull().isInstanceOf(ConnectException.class);
    assertThat(reasonThrowableReference.get().getReason()).containsIgnoringCase("Could not contact OBS");

  }

  @Disabled
  @Test
  void controllerDisconnectsWhenObsCannotIdentifyClient() {
    fail("to do, #34");
  }

}
