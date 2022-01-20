package io.obswebsocket.community.client.listener.lifecycle.communicator;

import io.obswebsocket.community.client.WebSocketCloseCode;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.message.authentication.Hello;
import io.obswebsocket.community.client.message.authentication.Identified;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.websocket.api.Session;

/**
 * Lifecycle listener that delegates to registered callbacks.
 */
@Slf4j
public class DelegatingCommunicatorLifecycleListener implements
    CommunicatorLifecycleListener {

  private final Consumer<Session> onConnectCallback;
  private final Consumer<Hello> onHelloCallback;
  private final Consumer<Identified> onIdentifiedCallback;
  private final Runnable onReadyCallback;
  private final Consumer<WebSocketCloseCode> onCloseCallback;
  private final Runnable onDisconnectCallback;
  private final Consumer<ReasonThrowable> onErrorCallback;

  public DelegatingCommunicatorLifecycleListener(
    Consumer<Session> onConnectCallback,
    Consumer<Hello> onHelloCallback,
    Consumer<Identified> onIdentifiedCallback, Runnable onReadyCallback,
    Consumer<WebSocketCloseCode> onCloseCallback, Runnable onDisconnectCallback,
    Consumer<ReasonThrowable> onErrorCallback) {
    this.onConnectCallback = onConnectCallback;
    this.onHelloCallback = onHelloCallback;
    this.onIdentifiedCallback = onIdentifiedCallback;
    this.onReadyCallback = onReadyCallback;
    this.onCloseCallback = onCloseCallback;
    this.onDisconnectCallback = onDisconnectCallback;
    this.onErrorCallback = onErrorCallback;
  }

  @Override
  public void onConnect(Session session) {
    if (onConnectCallback != null) {
      try {
        onConnectCallback.accept(session);
      } catch (Exception e) {
        log.warn("onConnect callback threw exception", e);
      }
    }
  }

  @Override
  public void onHello(Hello hello) {
    if (onHelloCallback != null) {
      try {
        onHelloCallback.accept(hello);
      } catch (Exception e) {
        log.warn("onHello callback threw exception", e);
      }
    }
  }

  @Override
  public void onIdentified(Identified identified) {
    if (onIdentifiedCallback != null) {
      try {
        onIdentifiedCallback.accept(identified);
      } catch (Exception e) {
        log.warn("onIdentified callback threw exception", e);
      }
    }
  }

  @Override
  public void onReady() {
    if (onReadyCallback != null) {
      try {
        onReadyCallback.run();
      } catch (Exception e) {
        log.warn("onReady callback threw exception", e);
      }
    }
  }

  @Override
  public void onClose(WebSocketCloseCode webSocketCloseCode) {
    if (onCloseCallback != null) {
      try {
        onCloseCallback.accept(webSocketCloseCode);
      } catch (Exception e) {
        log.warn("onClose callback threw exception", e);
      }
    }
  }

  @Override
  public void onDisconnect() {
    if (onDisconnectCallback != null) {
      try {
        onDisconnectCallback.run();
      } catch (Exception e) {
        log.warn("onDisconnect callback threw exception", e);
      }
    }
  }

  @Override
  public void onError(ReasonThrowable reasonThrowable) {
    if (onErrorCallback != null) {
      try {
        onErrorCallback.accept(reasonThrowable);
      } catch (Exception e) {
        log.warn("onError callback (ironically) threw an exception", e);
      }
    }
  }

}
