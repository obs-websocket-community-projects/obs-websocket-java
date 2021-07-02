package io.obswebsocket.community.client.listener.lifecycle.controller;

import io.obswebsocket.community.client.OBSRemoteController;
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
  public void onReady(OBSRemoteController controller) {
    listeners.forEach(it -> it.onReady(controller));
  }

  @Override
  public void onDisconnect(OBSRemoteController controller) {
    listeners.forEach(it -> it.onDisconnect(controller));
  }

  @Override
  public void onError(OBSRemoteController controller, ReasonThrowable reasonThrowable) {
    listeners.forEach(it -> it.onError(controller, reasonThrowable));
  }
}
