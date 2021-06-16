package net.twasi.obsremotejava.test.listeners;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.OBSRemoteController;
import net.twasi.obsremotejava.listener.lifecycle.ReasonThrowable;
import net.twasi.obsremotejava.listener.lifecycle.communicator.CommunicatorLifecycleListener.CodeReason;
import net.twasi.obsremotejava.listener.lifecycle.communicator.DelegatingCommunicatorLifecycleListener;
import net.twasi.obsremotejava.listener.lifecycle.controller.DelegatingControllerLifecycleListener;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Identified;
import org.eclipse.jetty.websocket.api.Session;
import org.junit.jupiter.api.Test;

public class DelegatingControllerLifecycleListenerTest {

  @Test
  void callbacksAreCalled() {

    // Given callbacks registered to the listener
    Consumer onReady = mock(Consumer.class);
    Consumer onDisconnect = mock(Consumer.class);
    BiConsumer onError = mock(BiConsumer.class);

    DelegatingControllerLifecycleListener listener = new DelegatingControllerLifecycleListener(
      onReady,
      onDisconnect,
      onError
    );

    // When invoked on the listener
    listener.onReady(mock(OBSRemoteController.class));
    listener.onDisconnect(mock(OBSRemoteController.class));
    listener.onError(mock(OBSRemoteController.class), mock(ReasonThrowable.class));

    // Then the callbacks are invoked
    verify(onReady).accept(any());
    verify(onDisconnect).accept(any());
    verify(onError).accept(any(), any());

  }

  @Test
  void nullsAreIgnored() {

    // Given a listener with null callbacks
    DelegatingControllerLifecycleListener listener = new DelegatingControllerLifecycleListener(
      null,
      null,
      null
    );

    // When each are called, then no exceptions are thrown
    listener.onReady(mock(OBSRemoteController.class));
    listener.onDisconnect(mock(OBSRemoteController.class));
    listener.onError(mock(OBSRemoteController.class), mock(ReasonThrowable.class));

  }

  @Test
  void exceptionsAreIgnored() {
    // Given a listener with exception throwing callbacks
    Consumer exceptionThrowingConsumer = (a) -> { throw new RuntimeException("whoops"); };
    BiConsumer exceptionThrowingBiConsumer = (a, b) -> { throw new RuntimeException("whoops"); };
    DelegatingControllerLifecycleListener listener = new DelegatingControllerLifecycleListener(
      exceptionThrowingConsumer,
      exceptionThrowingConsumer,
      exceptionThrowingBiConsumer
    );

    // When each are called, then no exceptions are thrown
    listener.onReady(mock(OBSRemoteController.class));
    listener.onDisconnect(mock(OBSRemoteController.class));
    listener.onError(mock(OBSRemoteController.class), mock(ReasonThrowable.class));

  }

}
