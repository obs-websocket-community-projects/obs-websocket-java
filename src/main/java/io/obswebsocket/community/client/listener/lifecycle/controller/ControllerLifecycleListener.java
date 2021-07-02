package io.obswebsocket.community.client.listener.lifecycle.controller;

import io.obswebsocket.community.client.OBSRemoteController;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;

public interface ControllerLifecycleListener {

  void onReady(OBSRemoteController controller);

  void onDisconnect(OBSRemoteController controller);

  void onError(OBSRemoteController controller, ReasonThrowable reasonThrowable);
}
