package io.obswebsocket.community.client.test.listeners;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
    Consumer onConnect = mock(Consumer.class);
    Consumer onHello = mock(Consumer.class);
    Consumer onIdentified = mock(Consumer.class);
    Runnable onReadyCallback = mock(Runnable.class);
    Consumer onClose = mock(Consumer.class);
    Runnable onDisconnectCallback = mock(Runnable.class);
    Consumer onError = mock(Consumer.class);
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
    listener.onConnect(mock(Session.class));
    listener.onHello(mock(Hello.class));
    listener.onIdentified(mock(Identified.class));
    listener.onReady();
    listener.onClose(WebSocketCloseCode.AlreadyIdentified);
    listener.onDisconnect();
    listener.onError(mock(ReasonThrowable.class));

    // Then the callbacks are invoked
    verify(onConnect).accept(any());
    verify(onHello).accept(any());
    verify(onIdentified).accept(any());
    verify(onReadyCallback).run();
    verify(onClose).accept(eq(WebSocketCloseCode.AlreadyIdentified));
    verify(onDisconnectCallback).run();
    verify(onError).accept(any());

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
    listener.onConnect(mock(Session.class));
    listener.onHello(mock(Hello.class));
    listener.onIdentified(mock(Identified.class));
    listener.onReady();
    listener.onClose(WebSocketCloseCode.AlreadyIdentified);
    listener.onDisconnect();
    listener.onError(mock(ReasonThrowable.class));

  }

  @Test
  void exceptionsAreIgnored() {
    // Given a listener with null callbacks
    Consumer exceptionThrowingConsumer = (a) -> {
      throw new RuntimeException("whoops");
    };
    Runnable exceptionThrowingRunnable = () -> {
      throw new RuntimeException("whoops");
    };

    DelegatingCommunicatorLifecycleListener listener = new DelegatingCommunicatorLifecycleListener(
        exceptionThrowingConsumer,
        exceptionThrowingConsumer,
        exceptionThrowingConsumer,
        exceptionThrowingRunnable,
        exceptionThrowingConsumer,
        exceptionThrowingRunnable,
        exceptionThrowingConsumer
    );

    // When each are called, then no exceptions are thrown
    listener.onConnect(mock(Session.class));
    listener.onHello(mock(Hello.class));
    listener.onIdentified(mock(Identified.class));
    listener.onReady();
    listener.onClose(WebSocketCloseCode.AlreadyIdentified);
    listener.onDisconnect();
    listener.onError(mock(ReasonThrowable.class));

  }

}
