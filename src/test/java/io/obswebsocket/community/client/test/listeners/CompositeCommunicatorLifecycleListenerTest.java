package io.obswebsocket.community.client.test.listeners;

import io.obswebsocket.community.client.OBSCommunicator;
import io.obswebsocket.community.client.ObsCommunicatorBuilder;
import io.obswebsocket.community.client.WebSocketCloseCode;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.listener.lifecycle.communicator.CommunicatorLifecycleListener;
import io.obswebsocket.community.client.listener.lifecycle.communicator.CommunicatorLifecycleListenerBuilder;
import io.obswebsocket.community.client.listener.lifecycle.communicator.CompositeCommunicatorLifecycleListener;
import io.obswebsocket.community.client.message.authentication.Hello;
import io.obswebsocket.community.client.message.authentication.Identified;
import org.eclipse.jetty.websocket.api.Session;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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

    CommunicatorLifecycleListener compositeListener = new CompositeCommunicatorLifecycleListener(listeners);

    // When called
    compositeListener.onConnect(mock(OBSCommunicator.class), mock(Session.class));
    compositeListener.onHello(mock(OBSCommunicator.class), mock(Hello.class));
    compositeListener.onIdentified(mock(OBSCommunicator.class), mock(Identified.class));
    compositeListener.onClose(mock(OBSCommunicator.class), WebSocketCloseCode.AlreadyIdentified);
    compositeListener.onError(mock(OBSCommunicator.class), mock(ReasonThrowable.class));

    // Then each is called
    listeners.forEach(listener -> {
      verify(listener).onConnect(any(), any());
      verify(listener).onHello(any(), any());
      verify(listener).onIdentified(any(), any());
      verify(listener).onClose(any(), eq(WebSocketCloseCode.AlreadyIdentified));
      verify(listener).onError(any(), any());
    });

  }

  @Test
  void lifecycleListenerBuilderProvidesCompositeListener() {
    assertThat(new CommunicatorLifecycleListenerBuilder(new ObsCommunicatorBuilder()).build())
      .isInstanceOf(CompositeCommunicatorLifecycleListener.class);
  }
}
