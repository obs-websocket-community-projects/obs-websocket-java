package io.obswebsocket.community.client.listener.lifecycle.communicator;

import io.obswebsocket.community.client.OBSCommunicatorBuilder;
import io.obswebsocket.community.client.WebSocketCloseCode;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.message.authentication.Hello;
import io.obswebsocket.community.client.message.authentication.Identified;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.jetty.websocket.api.Session;

public class CommunicatorLifecycleListenerBuilder {

  private final OBSCommunicatorBuilder obsCommunicatorBuilder;

  private Consumer<Session> onConnectCallback;
  private Consumer<Hello> onHelloCallback;
  private Consumer<Identified> onIdentifiedCallback;
  private Runnable onReadyCallback;
  private Consumer<WebSocketCloseCode> onCloseCallback;
  private Runnable onDisconnectCallback;
  private Consumer<ReasonThrowable> onErrorCallback;
  private boolean defaultLogging = true;

  public CommunicatorLifecycleListenerBuilder(
      OBSCommunicatorBuilder obsCommunicatorBuilder) {
    this.obsCommunicatorBuilder = obsCommunicatorBuilder;
  }

  public CommunicatorLifecycleListenerBuilder onConnect(
      Consumer<Session> onConnectCallback) {
    this.onConnectCallback = onConnectCallback;
    return this;
  }

  public CommunicatorLifecycleListenerBuilder onHello(
      Consumer<Hello> onHelloCallback) {
    this.onHelloCallback = onHelloCallback;
    return this;
  }

  public CommunicatorLifecycleListenerBuilder onIdentified(
      Consumer<Identified> onIdentifiedCallback) {
    this.onIdentifiedCallback = onIdentifiedCallback;
    return this;
  }

  public CommunicatorLifecycleListenerBuilder onReady(Runnable onReadyCallback) {
    this.onReadyCallback = onReadyCallback;
    return this;
  }

  public CommunicatorLifecycleListenerBuilder onClose(
      Consumer<WebSocketCloseCode> onCloseCallback) {
    this.onCloseCallback = onCloseCallback;
    return this;
  }

  public CommunicatorLifecycleListenerBuilder onDisconnect(
      Runnable onDisconnectCallback) {
    this.onDisconnectCallback = onDisconnectCallback;
    return this;
  }

  public CommunicatorLifecycleListenerBuilder onError(
      Consumer<ReasonThrowable> onErrorCallback) {
    this.onErrorCallback = onErrorCallback;
    return this;
  }

  public CommunicatorLifecycleListenerBuilder withDefaultLogging(boolean defaultLogging) {
    this.defaultLogging = defaultLogging;
    return this;
  }

  public OBSCommunicatorBuilder and() {
    return obsCommunicatorBuilder;
  }

  public CompositeCommunicatorLifecycleListener build() {
    List<CommunicatorLifecycleListener> listeners = new ArrayList<>();
    listeners.add(new DelegatingCommunicatorLifecycleListener(
        onConnectCallback,
        onHelloCallback,
        onIdentifiedCallback,
        onReadyCallback,
        onCloseCallback,
        onDisconnectCallback,
        onErrorCallback
    ));
    if (defaultLogging) {
      listeners.add(new LoggingCommunicatorLifecycleListener());
    }
    return new CompositeCommunicatorLifecycleListener(listeners);
  }

}
