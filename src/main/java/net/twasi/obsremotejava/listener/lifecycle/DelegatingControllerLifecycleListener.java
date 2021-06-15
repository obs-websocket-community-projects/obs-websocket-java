package net.twasi.obsremotejava.listener.lifecycle;

import java.util.function.BiConsumer;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.OBSRemoteController;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Identified;
import org.eclipse.jetty.websocket.api.Session;

/**
 * Lifecycle listener that delegates to registered callbacks.
 */
public class DelegatingControllerLifecycleListener implements LifecycleListener<OBSRemoteController> {
  private final BiConsumer<OBSRemoteController, Session> onConnectCallback;
  private final BiConsumer<OBSRemoteController, Hello> onHelloCallback;
  private final BiConsumer<OBSRemoteController, Identified> onIdentifiedCallback;
  private final BiConsumer<OBSRemoteController, CodeReason> onCloseCallback;
  private final BiConsumer<OBSRemoteController, ReasonThrowable> onErrorCallback;

  public DelegatingControllerLifecycleListener(
    BiConsumer<OBSRemoteController, Session> onConnectCallback,
    BiConsumer<OBSRemoteController, Hello> onHelloCallback,
    BiConsumer<OBSRemoteController, Identified> onIdentifiedCallback,
    BiConsumer<OBSRemoteController, CodeReason> onCloseCallback,
    BiConsumer<OBSRemoteController, ReasonThrowable> onErrorCallback) {
    this.onConnectCallback = onConnectCallback;
    this.onHelloCallback = onHelloCallback;
    this.onIdentifiedCallback = onIdentifiedCallback;
    this.onCloseCallback = onCloseCallback;
    this.onErrorCallback = onErrorCallback;
  }

  public void onConnect(OBSRemoteController communicator, Session session) {
    if(onConnectCallback != null) onConnectCallback.accept(communicator, session);
  }

  public void onHello(OBSRemoteController communicator, Hello hello) {
    if(onConnectCallback != null) onHelloCallback.accept(communicator, hello);
  }

  public void onIdentified(OBSRemoteController communicator,
    Identified identified) {
    if(onIdentifiedCallback != null) onIdentifiedCallback.accept(communicator, identified);
  }

  public void onClose(OBSRemoteController communicator,
    CodeReason codeReason) {
    if(onCloseCallback != null) onCloseCallback.accept(communicator, codeReason);
  }

  public void onError(OBSRemoteController communicator,
    ReasonThrowable reasonThrowable) {
    if(onErrorCallback != null) onErrorCallback.accept(communicator, reasonThrowable);
  }

}
