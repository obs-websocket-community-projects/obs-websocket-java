package io.obswebsocket.community.listener.lifecycle.controller;

import io.obswebsocket.community.OBSRemoteController;
import io.obswebsocket.community.listener.lifecycle.ReasonThrowable;

public interface ControllerLifecycleListener {
  void onReady(OBSRemoteController controller);
  void onDisconnect(OBSRemoteController controller);
  void onError(OBSRemoteController controller, ReasonThrowable reasonThrowable);
}
