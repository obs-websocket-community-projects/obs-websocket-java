package net.twasi.obsremotejava.test.listeners;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.function.BiConsumer;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.listener.lifecycle.ReasonThrowable;
import net.twasi.obsremotejava.listener.lifecycle.communicator.CommunicatorLifecycleListener.CodeReason;
import net.twasi.obsremotejava.listener.lifecycle.communicator.DelegatingCommunicatorLifecycleListener;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Identified;
import org.eclipse.jetty.websocket.api.Session;
import org.junit.jupiter.api.Test;

public class DelegatingCommunicatorLifecycleListenerTest {

  @Test
  void callbacksAreCalled() {

    // Given callbacks registered to the listener
    BiConsumer onConnect = mock(BiConsumer.class);
    BiConsumer onHello = mock(BiConsumer.class);
    BiConsumer onIdentified = mock(BiConsumer.class);
    BiConsumer onClose = mock(BiConsumer.class);
    BiConsumer onError = mock(BiConsumer.class);
    DelegatingCommunicatorLifecycleListener listener = new DelegatingCommunicatorLifecycleListener(
      onConnect,
      onHello,
      onIdentified,
      onClose,
      onError
    );

    // When invoked on the listener
    listener.onConnect(mock(OBSCommunicator.class), mock(Session.class));
    listener.onHello(mock(OBSCommunicator.class), mock(Hello.class));
    listener.onIdentified(mock(OBSCommunicator.class), mock(Identified.class));
    listener.onClose(mock(OBSCommunicator.class), mock(CodeReason.class));
    listener.onError(mock(OBSCommunicator.class), mock(ReasonThrowable.class));

    // Then the callbacks are invoked
    verify(onConnect).accept(any(), any());
    verify(onHello).accept(any(), any());
    verify(onIdentified).accept(any(), any());
    verify(onClose).accept(any(), any());
    verify(onError).accept(any(), any());

  }

  @Test
  void nullsAreIgnored() {

    // Given a listener with null callbacks
    DelegatingCommunicatorLifecycleListener listener = new DelegatingCommunicatorLifecycleListener(
      null,
      null,
      null,
      null,
      null
    );

    // When each are called, then no exceptions are thrown
    listener.onConnect(mock(OBSCommunicator.class), mock(Session.class));
    listener.onHello(mock(OBSCommunicator.class), mock(Hello.class));
    listener.onIdentified(mock(OBSCommunicator.class), mock(Identified.class));
    listener.onClose(mock(OBSCommunicator.class), mock(CodeReason.class));
    listener.onError(mock(OBSCommunicator.class), mock(ReasonThrowable.class));

  }

  @Test
  void exceptionsAreIgnored() {
    // Given a listener with null callbacks
    BiConsumer exceptionThrowingConsumer = (a, b) -> { throw new RuntimeException("whoops"); };
    DelegatingCommunicatorLifecycleListener listener = new DelegatingCommunicatorLifecycleListener(
      exceptionThrowingConsumer,
      exceptionThrowingConsumer,
      exceptionThrowingConsumer,
      exceptionThrowingConsumer,
      exceptionThrowingConsumer
    );

    // When each are called, then no exceptions are thrown
    listener.onConnect(mock(OBSCommunicator.class), mock(Session.class));
    listener.onHello(mock(OBSCommunicator.class), mock(Hello.class));
    listener.onIdentified(mock(OBSCommunicator.class), mock(Identified.class));
    listener.onClose(mock(OBSCommunicator.class), mock(CodeReason.class));
    listener.onError(mock(OBSCommunicator.class), mock(ReasonThrowable.class));

  }

}
