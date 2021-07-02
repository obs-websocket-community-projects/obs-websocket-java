package io.obswebsocket.community.client.test.listeners;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.obswebsocket.community.client.OBSRemoteController;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.listener.lifecycle.controller.DelegatingControllerLifecycleListener;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

public class DelegatingControllerLifecycleListenerTest {

  @Test
  void callbacksAreCalled() {

    // Given callbacks registered to the listener
    BiConsumer onError = mock(BiConsumer.class);

    DelegatingControllerLifecycleListener listener = new DelegatingControllerLifecycleListener(
        onError
    );

    // When invoked on the listener
    listener.onError(mock(OBSRemoteController.class), mock(ReasonThrowable.class));

    // Then the callbacks are invoked
    verify(onError).accept(any(), any());

  }

  @Test
  void nullsAreIgnored() {

    // Given a listener with null callbacks
    DelegatingControllerLifecycleListener listener = new DelegatingControllerLifecycleListener(
        null
    );

    // When each are called, then no exceptions are thrown
    listener.onError(mock(OBSRemoteController.class), mock(ReasonThrowable.class));

  }

  @Test
  void exceptionsAreIgnored() {
    // Given a listener with exception throwing callbacks
    Consumer exceptionThrowingConsumer = (a) -> {
      throw new RuntimeException("whoops");
    };
    BiConsumer exceptionThrowingBiConsumer = (a, b) -> {
      throw new RuntimeException("whoops");
    };
    DelegatingControllerLifecycleListener listener = new DelegatingControllerLifecycleListener(
        exceptionThrowingBiConsumer
    );

    // When each are called, then no exceptions are thrown
    listener.onError(mock(OBSRemoteController.class), mock(ReasonThrowable.class));

  }

}
