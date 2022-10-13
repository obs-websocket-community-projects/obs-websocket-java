package io.obswebsocket.community.client.listener.lifecycle.controller;

import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import java.util.ArrayList;
import java.util.List;

public class CompositeControllerLifecycleListener implements ControllerLifecycleListener {

  private final List<ControllerLifecycleListener> listeners = new ArrayList<>();

  public CompositeControllerLifecycleListener(List<ControllerLifecycleListener> listeners) {
    if (listeners != null) {
      this.listeners.addAll(listeners);
    }
  }

  @Override
  public void onError(ReasonThrowable reasonThrowable) {
    listeners.forEach(it -> it.onError(reasonThrowable));
  }
}
