package io.obswebsocket.community.client.listener.lifecycle.communicator;

import io.obswebsocket.community.client.WebSocketCloseCode;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.message.authentication.Hello;
import io.obswebsocket.community.client.message.authentication.Identified;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jetty.websocket.api.Session;

/**
 * Lifecycle listener that executes other lifecycle listeners in the order received.
 */
public class CompositeCommunicatorLifecycleListener implements CommunicatorLifecycleListener {

  private final List<CommunicatorLifecycleListener> listeners = new ArrayList<>();

  public CompositeCommunicatorLifecycleListener(List<CommunicatorLifecycleListener> listeners) {
    if (listeners != null) {
      this.listeners.addAll(listeners);
    }
  }

  @Override
  public void onConnect(Session session) {
    listeners.forEach(
        it -> it.onConnect(session)
    );
  }

  @Override
  public void onHello(Hello hello) {
    listeners.forEach(it -> it.onHello(hello));
  }

  @Override
  public void onIdentified(Identified identified) {
    listeners.forEach(it -> it.onIdentified(identified));
  }

  @Override
  public void onReady() {
    listeners.forEach(it -> it.onReady());
  }

  @Override
  public void onClose(WebSocketCloseCode webSocketCloseCode) {
    listeners.forEach(it -> it.onClose(webSocketCloseCode));
  }

  @Override
  public void onDisconnect() {
    listeners.forEach(it -> it.onDisconnect());
  }

  @Override
  public void onError(ReasonThrowable reasonThrowable) {
    listeners.forEach(it -> it.onError(reasonThrowable));
  }
}
