package io.obswebsocket.community.client.listener.lifecycle.controller;

import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;

/**
 * Lifecycle listener that delegates to registered callbacks.
 */
@Slf4j
public class DelegatingControllerLifecycleListener implements
    ControllerLifecycleListener {

  private final Consumer<ReasonThrowable> onErrorCallback;

  public DelegatingControllerLifecycleListener(
    Consumer<ReasonThrowable> onErrorCallback) {
    this.onErrorCallback = onErrorCallback;
  }

  @Override
  public void onError(ReasonThrowable reasonThrowable) {
    if (onErrorCallback != null) {
      try {
        onErrorCallback.accept(reasonThrowable);
      } catch (Exception e) {
        log.warn("onError callback (ironically) threw exception", e);
      }
    }
  }
}
