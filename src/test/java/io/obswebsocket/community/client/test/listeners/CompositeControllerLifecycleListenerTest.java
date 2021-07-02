package io.obswebsocket.community.client.test.listeners;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.obswebsocket.community.client.OBSRemoteControllerBuilder;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.listener.lifecycle.controller.CompositeControllerLifecycleListener;
import io.obswebsocket.community.client.listener.lifecycle.controller.ControllerLifecycleListener;
import io.obswebsocket.community.client.listener.lifecycle.controller.ControllerLifecycleListenerBuilder;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CompositeControllerLifecycleListenerTest {

  @Test
  void allListenersAreCalled() {
    // Given some listeners registered to a composite listener
    ControllerLifecycleListener listener1 = mock(
        ControllerLifecycleListener.class);
    ControllerLifecycleListener listener2 = mock(
        ControllerLifecycleListener.class);
    List<ControllerLifecycleListener> listeners = Arrays.asList(
        listener1, listener2
    );

    ControllerLifecycleListener compositeListener = new CompositeControllerLifecycleListener(
        listeners);

    // When called
    compositeListener.onError(mock(ReasonThrowable.class));

    // Then each is called
    listeners.forEach(listener -> {
      verify(listener).onError(any());
    });

  }

  @Test
  void lifecycleListenerBuilderProvidesCompositeListener() {
    assertThat(new ControllerLifecycleListenerBuilder(new OBSRemoteControllerBuilder()).build())
        .isInstanceOf(CompositeControllerLifecycleListener.class);
  }
}
