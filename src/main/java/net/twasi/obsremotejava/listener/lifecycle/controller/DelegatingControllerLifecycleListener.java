package net.twasi.obsremotejava.listener.lifecycle.controller;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import net.twasi.obsremotejava.OBSRemoteController;
import net.twasi.obsremotejava.listener.lifecycle.ReasonThrowable;
import net.twasi.obsremotejava.listener.lifecycle.communicator.CommunicatorLifecycleListener;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Identified;
import org.eclipse.jetty.websocket.api.Session;

/**
 * Lifecycle listener that delegates to registered callbacks.
 */
@Slf4j
public class DelegatingControllerLifecycleListener implements
  ControllerLifecycleListener {
  private final Consumer<OBSRemoteController> onReadyCallback;
  private final Consumer<OBSRemoteController> onDisconnectCallback;
  private final BiConsumer<OBSRemoteController, ReasonThrowable> onErrorCallback;

  public DelegatingControllerLifecycleListener(
    Consumer<OBSRemoteController> onReadyCallback,
    Consumer<OBSRemoteController> onDisconnectCallback,
    BiConsumer<OBSRemoteController, ReasonThrowable> onErrorCallback) {
    this.onReadyCallback = onReadyCallback;
    this.onDisconnectCallback = onDisconnectCallback;
    this.onErrorCallback = onErrorCallback;
  }

  @Override
  public void onReady(OBSRemoteController controller) {
    if(onReadyCallback != null) {
      try {
        onReadyCallback.accept(controller);
      } catch (Exception e) {
        log.warn("onReady callback threw exception", e);
      }
    }
  }

  @Override
  public void onDisconnect(OBSRemoteController controller) {
    if(onDisconnectCallback != null) {
      try {
        onDisconnectCallback.accept(controller);
      } catch (Exception e) {
        log.warn("onDisconnect callback threw exception");
      }
    }
  }

  @Override
  public void onError(OBSRemoteController controller, ReasonThrowable reasonThrowable) {
    if(onErrorCallback != null) {
      try {
        onErrorCallback.accept(controller, reasonThrowable);
      } catch (Exception e) {
        log.warn("onError callback (ironically) threw exception", e);
      }
    }
  }
}
