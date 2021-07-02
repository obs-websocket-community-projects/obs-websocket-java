package io.obswebsocket.community.client.listener.lifecycle.communicator;

import io.obswebsocket.community.client.OBSCommunicator;
import io.obswebsocket.community.client.WebSocketCloseCode;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.message.authentication.Hello;
import io.obswebsocket.community.client.message.authentication.Identified;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.websocket.api.Session;

/**
 * Lifecycle listener that delegates to registered callbacks.
 */
@Slf4j
public class DelegatingCommunicatorLifecycleListener implements
    CommunicatorLifecycleListener {

  private final BiConsumer<OBSCommunicator, Session> onConnectCallback;
  private final BiConsumer<OBSCommunicator, Hello> onHelloCallback;
  private final BiConsumer<OBSCommunicator, Identified> onIdentifiedCallback;
  private final Consumer<OBSCommunicator> onReadyCallback;
  private final BiConsumer<OBSCommunicator, WebSocketCloseCode> onCloseCallback;
  private final Consumer<OBSCommunicator> onDisconnectCallback;
  private final BiConsumer<OBSCommunicator, ReasonThrowable> onErrorCallback;

  public DelegatingCommunicatorLifecycleListener(
      BiConsumer<OBSCommunicator, Session> onConnectCallback,
      BiConsumer<OBSCommunicator, Hello> onHelloCallback,
      BiConsumer<OBSCommunicator, Identified> onIdentifiedCallback,
      Consumer<OBSCommunicator> onReadyCallback,
      BiConsumer<OBSCommunicator, WebSocketCloseCode> onCloseCallback,
      Consumer<OBSCommunicator> onDisconnectCallback,
      BiConsumer<OBSCommunicator, ReasonThrowable> onErrorCallback) {
    this.onConnectCallback = onConnectCallback;
    this.onHelloCallback = onHelloCallback;
    this.onIdentifiedCallback = onIdentifiedCallback;
    this.onReadyCallback = onReadyCallback;
    this.onCloseCallback = onCloseCallback;
    this.onDisconnectCallback = onDisconnectCallback;
    this.onErrorCallback = onErrorCallback;
  }

  public void onConnect(OBSCommunicator communicator, Session session) {
    if (onConnectCallback != null) {
      try {
        onConnectCallback.accept(communicator, session);
      } catch (Exception e) {
        log.warn("onConnect callback threw exception", e);
      }
    }
  }

  public void onHello(OBSCommunicator communicator, Hello hello) {
    if (onHelloCallback != null) {
      try {
        onHelloCallback.accept(communicator, hello);
      } catch (Exception e) {
        log.warn("onHello callback threw exception", e);
      }
    }
  }

  public void onIdentified(OBSCommunicator communicator, Identified identified) {
    if (onIdentifiedCallback != null) {
      try {
        onIdentifiedCallback.accept(communicator, identified);
      } catch (Exception e) {
        log.warn("onIdentified callback threw exception", e);
      }
    }
  }

  @Override
  public void onReady(OBSCommunicator communicator) {
    if (onReadyCallback != null) {
      try {
        onReadyCallback.accept(communicator);
      } catch (Exception e) {
        log.warn("onReady callback threw exception", e);
      }
    }
  }

  public void onClose(OBSCommunicator communicator, WebSocketCloseCode webSocketCloseCode) {
    if (onCloseCallback != null) {
      try {
        onCloseCallback.accept(communicator, webSocketCloseCode);
      } catch (Exception e) {
        log.warn("onClose callback threw exception", e);
      }
    }
  }

  @Override
  public void onDisconnect(OBSCommunicator communicator) {
    if (onDisconnectCallback != null) {
      try {
        onDisconnectCallback.accept(communicator);
      } catch (Exception e) {
        log.warn("onDisconnect callback threw exception", e);
      }
    }
  }

  public void onError(OBSCommunicator communicator, ReasonThrowable reasonThrowable) {
    if (onErrorCallback != null) {
      try {
        onErrorCallback.accept(communicator, reasonThrowable);
      } catch (Exception e) {
        log.warn("onError callback (ironically) threw an exception", e);
      }
    }
  }

}
