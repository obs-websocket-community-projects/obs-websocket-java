package net.twasi.obsremotejava.listener.lifecycle.controller;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.twasi.obsremotejava.OBSRemoteController;
import net.twasi.obsremotejava.listener.lifecycle.ReasonThrowable;
import net.twasi.obsremotejava.listener.lifecycle.communicator.CommunicatorLifecycleListener;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Identified;
import org.eclipse.jetty.websocket.api.Session;

/**
 * Lifecycle listener that delegates to registered callbacks.
 */
public class DelegatingControllerCommunicatorLifecycleListener implements
  ControllerLifecycleListener {
  private final Consumer<OBSRemoteController> onReadyCallback;
  private final Consumer<OBSRemoteController> onDisconnectCallback;
  private final BiConsumer<OBSRemoteController, ReasonThrowable> onErrorCallback;

  public DelegatingControllerCommunicatorLifecycleListener(
    Consumer<OBSRemoteController> onReadyCallback,
    Consumer<OBSRemoteController> onDisconnectCallback,
    BiConsumer<OBSRemoteController, ReasonThrowable> onErrorCallback) {
    this.onReadyCallback = onReadyCallback;
    this.onDisconnectCallback = onDisconnectCallback;
    this.onErrorCallback = onErrorCallback;
  }

  @Override
  public void onReady(OBSRemoteController controller) {
    if(onReadyCallback != null) onReadyCallback.accept(controller);
  }

  @Override
  public void onDisconnect(OBSRemoteController controller) {
    if(onDisconnectCallback != null) onDisconnectCallback.accept(controller);
  }

  @Override
  public void onError(OBSRemoteController controller, ReasonThrowable reasonThrowable) {
    if(onErrorCallback != null) onErrorCallback.accept(controller, reasonThrowable);
  }
}
