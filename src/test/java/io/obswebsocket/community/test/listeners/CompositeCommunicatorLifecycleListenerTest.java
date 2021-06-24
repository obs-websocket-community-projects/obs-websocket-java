package io.obswebsocket.community.test.listeners;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import io.obswebsocket.community.OBSCommunicator;
import io.obswebsocket.community.ObsCommunicatorBuilder;
import io.obswebsocket.community.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.listener.lifecycle.communicator.CompositeCommunicatorLifecycleListener;
import io.obswebsocket.community.listener.lifecycle.communicator.CommunicatorLifecycleListener;
import io.obswebsocket.community.listener.lifecycle.communicator.CommunicatorLifecycleListenerBuilder;
import io.obswebsocket.community.message.authentication.Hello;
import io.obswebsocket.community.message.authentication.Identified;
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

    CommunicatorLifecycleListener compositeListener = new CompositeCommunicatorLifecycleListener(listeners);

    // When called
    compositeListener.onConnect(mock(OBSCommunicator.class), mock(Session.class));
    compositeListener.onHello(mock(OBSCommunicator.class), mock(Hello.class));
    compositeListener.onIdentified(mock(OBSCommunicator.class), mock(Identified.class));
    compositeListener.onClose(mock(OBSCommunicator.class), mock(CommunicatorLifecycleListener.CodeReason.class));
    compositeListener.onError(mock(OBSCommunicator.class), mock(ReasonThrowable.class));

    // Then each is called
    listeners.forEach(listener -> {
      verify(listener).onConnect(any(), any());
      verify(listener).onHello(any(), any());
      verify(listener).onIdentified(any(), any());
      verify(listener).onClose(any(), any());
      verify(listener).onError(any(), any());
    });

  }

  @Test
  void lifecycleListenerBuilderProvidesCompositeListener() {
    assertThat(new CommunicatorLifecycleListenerBuilder(new ObsCommunicatorBuilder()).build())
      .isInstanceOf(CompositeCommunicatorLifecycleListener.class);
  }
}
