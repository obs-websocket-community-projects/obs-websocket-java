package io.obswebsocket.community.client.listener.lifecycle.communicator;

import io.obswebsocket.community.client.OBSCommunicator;
import io.obswebsocket.community.client.ObsCommunicatorBuilder;
import io.obswebsocket.community.client.WebSocketCloseCode;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.message.authentication.Hello;
import io.obswebsocket.community.client.message.authentication.Identified;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.jetty.websocket.api.Session;

public class CommunicatorLifecycleListenerBuilder {

  private final Consumer DEFAULT_CONSUMER = obj -> {
  };
  private final BiConsumer DEFAULT_BICONSUMER = (a, b) -> {
  };

  private final ObsCommunicatorBuilder obsCommunicatorBuilder;

  private BiConsumer<OBSCommunicator, Session> onConnectCallback;
  private BiConsumer<OBSCommunicator, Hello> onHelloCallback;
  private BiConsumer<OBSCommunicator, Identified> onIdentifiedCallback;
  private Consumer<OBSCommunicator> onReadyCallback;
  private BiConsumer<OBSCommunicator, WebSocketCloseCode> onCloseCallback;
  private Consumer<OBSCommunicator> onDisconnectCallback;
  private BiConsumer<OBSCommunicator, ReasonThrowable> onErrorCallback;
  private boolean defaultLogging = true;

  public CommunicatorLifecycleListenerBuilder(
      ObsCommunicatorBuilder obsCommunicatorBuilder) {
    this.obsCommunicatorBuilder = obsCommunicatorBuilder;
  }

  public CommunicatorLifecycleListenerBuilder onConnect(
      BiConsumer<OBSCommunicator, Session> onConnectCallback) {
    this.onConnectCallback = onConnectCallback;
    return this;
  }

  public CommunicatorLifecycleListenerBuilder onHello(
      BiConsumer<OBSCommunicator, Hello> onHelloCallback) {
    this.onHelloCallback = onHelloCallback;
    return this;
  }

  public CommunicatorLifecycleListenerBuilder onIdentified(
      BiConsumer<OBSCommunicator, Identified> onIdentifiedCallback) {
    this.onIdentifiedCallback = onIdentifiedCallback;
    return this;
  }

  public CommunicatorLifecycleListenerBuilder onReady(Consumer<OBSCommunicator> onReadyCallback) {
    this.onReadyCallback = onReadyCallback;
    return this;
  }

  public CommunicatorLifecycleListenerBuilder onClose(
      BiConsumer<OBSCommunicator, WebSocketCloseCode> onCloseCallback) {
    this.onCloseCallback = onCloseCallback;
    return this;
  }

  public CommunicatorLifecycleListenerBuilder onDisconnect(
      Consumer<OBSCommunicator> onDisconnectCallback) {
    this.onDisconnectCallback = onDisconnectCallback;
    return this;
  }

  public CommunicatorLifecycleListenerBuilder onError(
      BiConsumer<OBSCommunicator, ReasonThrowable> onErrorCallback) {
    this.onErrorCallback = onErrorCallback;
    return this;
  }

  public CommunicatorLifecycleListenerBuilder withDefaultLogging(boolean defaultLogging) {
    this.defaultLogging = defaultLogging;
    return this;
  }

  public ObsCommunicatorBuilder and() {
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
