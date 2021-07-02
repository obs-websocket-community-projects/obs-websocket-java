package io.obswebsocket.community.client.test.listeners;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.obswebsocket.community.client.OBSCommunicator;
import io.obswebsocket.community.client.WebSocketCloseCode;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.listener.lifecycle.communicator.DelegatingCommunicatorLifecycleListener;
import io.obswebsocket.community.client.message.authentication.Hello;
import io.obswebsocket.community.client.message.authentication.Identified;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.jetty.websocket.api.Session;
import org.junit.jupiter.api.Test;

public class DelegatingCommunicatorLifecycleListenerTest {

  @Test
  void callbacksAreCalled() {

    // Given callbacks registered to the listener
    BiConsumer onConnect = mock(BiConsumer.class);
    BiConsumer onHello = mock(BiConsumer.class);
    BiConsumer onIdentified = mock(BiConsumer.class);
    Consumer onReadyCallback = mock(Consumer.class);
    BiConsumer onClose = mock(BiConsumer.class);
    Consumer onDisconnectCallback = mock(Consumer.class);
    BiConsumer onError = mock(BiConsumer.class);
    DelegatingCommunicatorLifecycleListener listener = new DelegatingCommunicatorLifecycleListener(
        onConnect,
        onHello,
        onIdentified,
        onReadyCallback,
        onClose,
        onDisconnectCallback,
        onError
    );

    // When invoked on the listener
    listener.onConnect(mock(OBSCommunicator.class), mock(Session.class));
    listener.onHello(mock(OBSCommunicator.class), mock(Hello.class));
    listener.onIdentified(mock(OBSCommunicator.class), mock(Identified.class));
    listener.onReady(mock(OBSCommunicator.class));
    listener.onClose(mock(OBSCommunicator.class), WebSocketCloseCode.AlreadyIdentified);
    listener.onDisconnect(mock(OBSCommunicator.class));
    listener.onError(mock(OBSCommunicator.class), mock(ReasonThrowable.class));

    // Then the callbacks are invoked
    verify(onConnect).accept(any(), any());
    verify(onHello).accept(any(), any());
    verify(onIdentified).accept(any(), any());
    verify(onReadyCallback).accept(any());
    verify(onClose).accept(any(), eq(WebSocketCloseCode.AlreadyIdentified));
    verify(onDisconnectCallback).accept(any());
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
        null,
        null,
        null
    );

    // When each are called, then no exceptions are thrown
    listener.onConnect(mock(OBSCommunicator.class), mock(Session.class));
    listener.onHello(mock(OBSCommunicator.class), mock(Hello.class));
    listener.onIdentified(mock(OBSCommunicator.class), mock(Identified.class));
    listener.onReady(mock(OBSCommunicator.class));
    listener.onClose(mock(OBSCommunicator.class), WebSocketCloseCode.AlreadyIdentified);
    listener.onDisconnect(mock(OBSCommunicator.class));
    listener.onError(mock(OBSCommunicator.class), mock(ReasonThrowable.class));

  }

  @Test
  void exceptionsAreIgnored() {
    // Given a listener with null callbacks
    BiConsumer exceptionThrowingBiConsumer = (a, b) -> {
      throw new RuntimeException("whoops");
    };
    Consumer exceptionThrowingConsumer = (a) -> {
      throw new RuntimeException("whoops");
    };

    DelegatingCommunicatorLifecycleListener listener = new DelegatingCommunicatorLifecycleListener(
        exceptionThrowingBiConsumer,
        exceptionThrowingBiConsumer,
        exceptionThrowingBiConsumer,
        exceptionThrowingConsumer,
        exceptionThrowingBiConsumer,
        exceptionThrowingConsumer,
        exceptionThrowingBiConsumer
    );

    // When each are called, then no exceptions are thrown
    listener.onConnect(mock(OBSCommunicator.class), mock(Session.class));
    listener.onHello(mock(OBSCommunicator.class), mock(Hello.class));
    listener.onIdentified(mock(OBSCommunicator.class), mock(Identified.class));
    listener.onReady(mock(OBSCommunicator.class));
    listener.onClose(mock(OBSCommunicator.class), WebSocketCloseCode.AlreadyIdentified);
    listener.onDisconnect(mock(OBSCommunicator.class));
    listener.onError(mock(OBSCommunicator.class), mock(ReasonThrowable.class));

  }

}
