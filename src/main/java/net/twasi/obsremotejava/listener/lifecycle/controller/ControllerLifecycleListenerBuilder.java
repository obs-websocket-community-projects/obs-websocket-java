package net.twasi.obsremotejava.listener.lifecycle.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.twasi.obsremotejava.OBSRemoteController;
import net.twasi.obsremotejava.ObsRemoteControllerBuilder;
import net.twasi.obsremotejava.listener.lifecycle.communicator.CompositeCommunicatorLifecycleListener;
import net.twasi.obsremotejava.listener.lifecycle.communicator.LoggingCommunicatorLifecycleListener;
import net.twasi.obsremotejava.listener.lifecycle.communicator.CommunicatorLifecycleListener;
import net.twasi.obsremotejava.listener.lifecycle.communicator.CommunicatorLifecycleListener.CodeReason;
import net.twasi.obsremotejava.listener.lifecycle.ReasonThrowable;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Identified;
import org.eclipse.jetty.websocket.api.Session;

public class ControllerLifecycleListenerBuilder {
  private final Consumer DEFAULT_CONSUMER = (a) -> {};
  private final BiConsumer DEFAULT_BICONSUMER = (a, b) -> {};

  private final ObsRemoteControllerBuilder obsRemoteControllerBuilder;

  private Consumer<OBSRemoteController> onReadyCallback = DEFAULT_CONSUMER;
  private Consumer<OBSRemoteController> onDisconnectCallback = DEFAULT_CONSUMER;
  private BiConsumer<OBSRemoteController, ReasonThrowable> onErrorCallback = DEFAULT_BICONSUMER;

  private boolean defaultLogging = true;

  public ControllerLifecycleListenerBuilder(
    ObsRemoteControllerBuilder obsRemoteControllerBuilder) {
    this.obsRemoteControllerBuilder = obsRemoteControllerBuilder;
  }

  public ControllerLifecycleListenerBuilder onReady(Consumer<OBSRemoteController> onReadyCallback) {
    this.onReadyCallback = onReadyCallback;
    return this;
  }

  public ControllerLifecycleListenerBuilder onDisconnect(Consumer<OBSRemoteController> onDisconnectCallback) {
    this.onDisconnectCallback = onDisconnectCallback;
    return this;
  }

  public ControllerLifecycleListenerBuilder onError(BiConsumer<OBSRemoteController, ReasonThrowable> onErrorCallback) {
    this.onErrorCallback = onErrorCallback;
    return this;
  }

  public ControllerLifecycleListenerBuilder withDefaultLogging(boolean defaultLogging) {
    this.defaultLogging = defaultLogging;
    return this;
  }

  public ObsRemoteControllerBuilder and() {
    return obsRemoteControllerBuilder;
  }

  public CompositeControllerLifecycleListener build() {
    List<ControllerLifecycleListener> listeners = new ArrayList<>();
    listeners.add(new DelegatingControllerCommunicatorLifecycleListener(
      onReadyCallback,
      onDisconnectCallback,
      onErrorCallback
    ));
    if(defaultLogging) listeners.add(new LoggingControllerLifecycleListener());
    return new CompositeControllerLifecycleListener(listeners);
  }

}
