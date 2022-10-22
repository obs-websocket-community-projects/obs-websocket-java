package io.obswebsocket.community.client.listener.lifecycle.controller;

import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;

/**
 * A listener that is invoked by the ${@link io.obswebsocket.community.client.OBSRemoteController} on
 * each respective event.
 */
public interface ControllerLifecycleListener {
  void onError(ReasonThrowable reasonThrowable);
}
