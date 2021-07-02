package io.obswebsocket.community.client.test.listeners;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.listener.lifecycle.controller.DelegatingControllerLifecycleListener;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

public class DelegatingControllerLifecycleListenerTest {

  @Test
  void callbacksAreCalled() {

    // Given callbacks registered to the listener
    Consumer onError = mock(Consumer.class);

    DelegatingControllerLifecycleListener listener = new DelegatingControllerLifecycleListener(
        onError
    );

    // When invoked on the listener
    listener.onError(mock(ReasonThrowable.class));

    // Then the callbacks are invoked
    verify(onError).accept(any());

  }

  @Test
  void nullsAreIgnored() {

    // Given a listener with null callbacks
    DelegatingControllerLifecycleListener listener = new DelegatingControllerLifecycleListener(
        null
    );

    // When each are called, then no exceptions are thrown
    listener.onError(mock(ReasonThrowable.class));

  }

  @Test
  void exceptionsAreIgnored() {
    // Given a listener with exception throwing callbacks
    Consumer exceptionThrowingConsumer = (a) -> {
      throw new RuntimeException("whoops");
    };
    DelegatingControllerLifecycleListener listener = new DelegatingControllerLifecycleListener(
        exceptionThrowingConsumer
    );

    // When each are called, then no exceptions are thrown
    listener.onError(mock(ReasonThrowable.class));

  }

}
