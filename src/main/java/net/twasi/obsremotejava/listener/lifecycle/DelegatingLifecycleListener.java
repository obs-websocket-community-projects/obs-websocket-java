package net.twasi.obsremotejava.listener.lifecycle;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Identified;
import org.eclipse.jetty.websocket.api.Session;

/**
 * Lifecycle listener that delegates to registered callbacks.
 */
public class DelegatingLifecycleListener implements LifecycleListener {
  private final Consumer<Session> onConnectCallback;
  private final Consumer<Hello> onHelloCallback;
  private final BiConsumer<OBSCommunicator, Identified> onIdentifiedCallback;
  private final BiConsumer<Integer, String> onCloseCallback;
  private final BiConsumer<String, Throwable> onErrorCallback;

  public DelegatingLifecycleListener(
    Consumer<Session> onConnectCallback,
    Consumer<Hello> onHelloCallback,
    BiConsumer<OBSCommunicator, Identified> onIdentifiedCallback,
    BiConsumer<Integer, String> onCloseCallback,
    BiConsumer<String, Throwable> onErrorCallback) {
    this.onConnectCallback = onConnectCallback;
    this.onHelloCallback = onHelloCallback;
    this.onIdentifiedCallback = onIdentifiedCallback;
    this.onCloseCallback = onCloseCallback;
    this.onErrorCallback = onErrorCallback;
  }

  public void onConnect(Session session) {
    if(onConnectCallback != null) onConnectCallback.accept(session);
  }

  public void onHello(Hello hello) {
    if(onConnectCallback != null) onHelloCallback.accept(hello);
  }

  public void onIdentified(OBSCommunicator communicator,
    Identified identified) {
    if(onIdentifiedCallback != null) onIdentifiedCallback.accept(communicator, identified);
  }

  public void onClose(Integer code, String reason) {
    if(onCloseCallback != null) onCloseCallback.accept(code, reason);
  }

  public void onError(String reason, Throwable throwable) {
    if(onErrorCallback != null) onErrorCallback.accept(reason, throwable);
  }

}
