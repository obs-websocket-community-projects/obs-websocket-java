package net.twasi.obsremotejava.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.OBSRemoteController;
import net.twasi.obsremotejava.ObsCommunicatorBuilder;
import net.twasi.obsremotejava.ObsRemoteControllerBuilder;
import net.twasi.obsremotejava.listener.lifecycle.ReasonThrowable;
import net.twasi.obsremotejava.listener.lifecycle.communicator.CommunicatorLifecycleListener;
import net.twasi.obsremotejava.listener.lifecycle.communicator.CommunicatorLifecycleListenerBuilder;
import net.twasi.obsremotejava.listener.lifecycle.communicator.CompositeCommunicatorLifecycleListener;
import net.twasi.obsremotejava.listener.lifecycle.controller.CompositeControllerLifecycleListener;
import net.twasi.obsremotejava.listener.lifecycle.controller.ControllerLifecycleListener;
import net.twasi.obsremotejava.listener.lifecycle.controller.ControllerLifecycleListenerBuilder;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Identified;
import org.eclipse.jetty.websocket.api.Session;
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

    ControllerLifecycleListener compositeListener = new CompositeControllerLifecycleListener(listeners);

    // When called
    compositeListener.onReady(mock(OBSRemoteController.class));
    compositeListener.onDisconnect(mock(OBSRemoteController.class));
    compositeListener.onError(mock(OBSRemoteController.class), mock(ReasonThrowable.class));

    // Then each is called
    listeners.forEach(listener -> {
      verify(listener).onReady(any());
      verify(listener).onDisconnect(any());
      verify(listener).onError(any(), any());
    });

  }

  @Test
  void lifecycleListenerBuilderProvidesCompositeListener() {
    assertThat(new ControllerLifecycleListenerBuilder(new ObsRemoteControllerBuilder()).build())
      .isInstanceOf(CompositeControllerLifecycleListener.class);
  }
}
