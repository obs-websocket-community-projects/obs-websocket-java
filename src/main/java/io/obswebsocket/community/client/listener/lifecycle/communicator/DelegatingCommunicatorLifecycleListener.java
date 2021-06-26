package io.obswebsocket.community.client.listener.lifecycle.communicator;

import io.obswebsocket.community.client.OBSCommunicator;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.message.authentication.Hello;
import io.obswebsocket.community.client.message.authentication.Identified;
import lombok.extern.slf4j.Slf4j;
import java.util.function.BiConsumer;

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
    if(onConnectCallback != null) {
      try{
        onConnectCallback.accept(communicator, session);
      } catch (Exception e) {
        log.warn("onConnect callback threw exception", e);
      }
    }
  }

  public void onHello(OBSCommunicator communicator, Hello hello) {
    if(onHelloCallback != null) {
      try {
        onHelloCallback.accept(communicator, hello);
      } catch (Exception e) {
        log.warn("onHello callback threw exception", e);
      }
    }
  }

  public void onIdentified(OBSCommunicator communicator, Identified identified) {
    if(onIdentifiedCallback != null) {
      try {
        onIdentifiedCallback.accept(communicator, identified);
      } catch (Exception e) {
        log.warn("onIdentified callback threw exception", e);
      }
    }
  }

  public void onClose(OBSCommunicator communicator, CodeReason codeReason) {
    if(onCloseCallback != null) {
      try {
        onCloseCallback.accept(communicator, codeReason);
      } catch (Exception e) {
        log.warn("onClose callback threw exception", e);
      }
    }
  }

  public void onError(OBSCommunicator communicator, ReasonThrowable reasonThrowable) {
    if(onErrorCallback != null) {
      try {
        onErrorCallback.accept(communicator, reasonThrowable);
      } catch (Exception e) {
        log.warn("onError callback (ironically) threw an exception", e);
      }
    }
  }

}
