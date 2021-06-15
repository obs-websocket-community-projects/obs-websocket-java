package net.twasi.obsremotejava.listener.lifecycle;

import java.util.function.BiConsumer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Identified;
import org.eclipse.jetty.websocket.api.Session;

/**
 * Lifecycle listener that delegates to registered callbacks.
 */
public class DelegatingCommunicatorLifecycleListener implements LifecycleListener<OBSCommunicator> {
  private final BiConsumer<OBSCommunicator, Session> onConnectCallback;
  private final BiConsumer<OBSCommunicator, Hello> onHelloCallback;
  private final BiConsumer<OBSCommunicator, Identified> onIdentifiedCallback;
  private final BiConsumer<OBSCommunicator, CodeReason> onCloseCallback;
  private final BiConsumer<OBSCommunicator, ReasonThrowable> onErrorCallback;

  public DelegatingCommunicatorLifecycleListener(
    BiConsumer<OBSCommunicator, Session> onConnectCallback,
    BiConsumer<OBSCommunicator, Hello> onHelloCallback,
    BiConsumer<OBSCommunicator, Identified> onIdentifiedCallback,
    BiConsumer<OBSCommunicator, CodeReason> onCloseCallback,
    BiConsumer<OBSCommunicator, ReasonThrowable> onErrorCallback) {
    this.onConnectCallback = onConnectCallback;
    this.onHelloCallback = onHelloCallback;
    this.onIdentifiedCallback = onIdentifiedCallback;
    this.onCloseCallback = onCloseCallback;
    this.onErrorCallback = onErrorCallback;
  }

  public void onConnect(OBSCommunicator communicator, Session session) {
    if(onConnectCallback != null) onConnectCallback.accept(communicator, session);
  }

  public void onHello(OBSCommunicator communicator, Hello hello) {
    if(onConnectCallback != null) onHelloCallback.accept(communicator, hello);
  }

  public void onIdentified(OBSCommunicator communicator,
    Identified identified) {
    if(onIdentifiedCallback != null) onIdentifiedCallback.accept(communicator, identified);
  }

  public void onClose(OBSCommunicator communicator,
    CodeReason codeReason) {
    if(onCloseCallback != null) onCloseCallback.accept(communicator, codeReason);
  }

  public void onError(OBSCommunicator communicator,
    ReasonThrowable reasonThrowable) {
    if(onErrorCallback != null) onErrorCallback.accept(communicator, reasonThrowable);
  }

}
