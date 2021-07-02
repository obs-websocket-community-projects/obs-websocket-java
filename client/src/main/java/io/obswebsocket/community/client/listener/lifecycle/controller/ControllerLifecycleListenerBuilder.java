package io.obswebsocket.community.client.listener.lifecycle.controller;

import io.obswebsocket.community.client.OBSRemoteControllerBuilder;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ControllerLifecycleListenerBuilder {

  private final OBSRemoteControllerBuilder obsRemoteControllerBuilder;

  private Consumer<ReasonThrowable> onErrorCallback;

  private boolean defaultLogging = true;

  public ControllerLifecycleListenerBuilder(
      OBSRemoteControllerBuilder obsRemoteControllerBuilder) {
    this.obsRemoteControllerBuilder = obsRemoteControllerBuilder;
  }

  public ControllerLifecycleListenerBuilder onError(
    Consumer<ReasonThrowable> onErrorCallback) {
    this.onErrorCallback = onErrorCallback;
    return this;
  }

  public ControllerLifecycleListenerBuilder withDefaultLogging(boolean defaultLogging) {
    this.defaultLogging = defaultLogging;
    return this;
  }

  public OBSRemoteControllerBuilder and() {
    return obsRemoteControllerBuilder;
  }

  public CompositeControllerLifecycleListener build() {
    List<ControllerLifecycleListener> listeners = new ArrayList<>();
    listeners.add(new DelegatingControllerLifecycleListener(
        onErrorCallback
    ));
    if (defaultLogging) {
      listeners.add(new LoggingControllerLifecycleListener());
    }
    return new CompositeControllerLifecycleListener(listeners);
  }

}
