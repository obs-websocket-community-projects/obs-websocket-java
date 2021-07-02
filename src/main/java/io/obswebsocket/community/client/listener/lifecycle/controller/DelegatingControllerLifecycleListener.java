package io.obswebsocket.community.client.listener.lifecycle.controller;

import io.obswebsocket.community.client.OBSRemoteController;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;

/**
 * Lifecycle listener that delegates to registered callbacks.
 */
@Slf4j
public class DelegatingControllerLifecycleListener implements
    ControllerLifecycleListener {

  private final BiConsumer<OBSRemoteController, ReasonThrowable> onErrorCallback;

  public DelegatingControllerLifecycleListener(
      BiConsumer<OBSRemoteController, ReasonThrowable> onErrorCallback) {
    this.onErrorCallback = onErrorCallback;
  }

  @Override
  public void onError(OBSRemoteController controller, ReasonThrowable reasonThrowable) {
    if (onErrorCallback != null) {
      try {
        onErrorCallback.accept(controller, reasonThrowable);
      } catch (Exception e) {
        log.warn("onError callback (ironically) threw exception", e);
      }
    }
  }
}
