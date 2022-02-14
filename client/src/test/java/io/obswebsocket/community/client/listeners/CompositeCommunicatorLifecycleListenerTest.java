package io.obswebsocket.community.client.listeners;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.obswebsocket.community.client.OBSCommunicatorBuilder;
import io.obswebsocket.community.client.WebSocketCloseCode;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.listener.lifecycle.communicator.CommunicatorLifecycleListener;
import io.obswebsocket.community.client.listener.lifecycle.communicator.CommunicatorLifecycleListenerBuilder;
import io.obswebsocket.community.client.listener.lifecycle.communicator.CompositeCommunicatorLifecycleListener;
import io.obswebsocket.community.client.message.authentication.Hello;
import io.obswebsocket.community.client.message.authentication.Identified;
import java.util.Arrays;
import java.util.List;
import org.eclipse.jetty.websocket.api.Session;
import org.junit.jupiter.api.Test;

public class CompositeCommunicatorLifecycleListenerTest {

  @Test
  void allListenersAreCalled() {
    // Given some listeners registered to a composite listener
    CommunicatorLifecycleListener communicatorLifecycleListener1 = mock(
        CommunicatorLifecycleListener.class);
    CommunicatorLifecycleListener communicatorLifecycleListener2 = mock(
        CommunicatorLifecycleListener.class);
    List<CommunicatorLifecycleListener> listeners = Arrays.asList(
        communicatorLifecycleListener1, communicatorLifecycleListener2
    );

    CommunicatorLifecycleListener compositeListener = new CompositeCommunicatorLifecycleListener(
        listeners);

    // When called
    compositeListener.onConnect(mock(Session.class));
    compositeListener.onHello(mock(Hello.class));
    compositeListener.onIdentified(mock(Identified.class));
    compositeListener.onReady();
    compositeListener.onClose(WebSocketCloseCode.AlreadyIdentified);
    compositeListener.onDisconnect();
    compositeListener.onError(mock(ReasonThrowable.class));

    // Then each is called
    listeners.forEach(listener -> {
      verify(listener).onConnect(any());
      verify(listener).onHello(any());
      verify(listener).onIdentified(any());
      verify(listener).onReady();
      verify(listener).onClose(eq(WebSocketCloseCode.AlreadyIdentified));
      verify(listener).onDisconnect();
      verify(listener).onError(any());
    });

  }

  @Test
  void lifecycleListenerBuilderProvidesCompositeListener() {
    assertThat(new CommunicatorLifecycleListenerBuilder(new OBSCommunicatorBuilder()).build())
        .isInstanceOf(CompositeCommunicatorLifecycleListener.class);
  }
}
