package io.obswebsocket.community.client.listener.lifecycle.communicator;

import io.obswebsocket.community.client.OBSCommunicator;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.message.authentication.Hello;
import io.obswebsocket.community.client.message.authentication.Identified;
import org.eclipse.jetty.websocket.api.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Lifecycle listener that executes other lifecycle listeners in the order received.
 */
public class CompositeCommunicatorLifecycleListener implements CommunicatorLifecycleListener {

  private final List<CommunicatorLifecycleListener> listeners = new ArrayList<>();

  public CompositeCommunicatorLifecycleListener(List<CommunicatorLifecycleListener> listeners) {
    if(listeners != null) this.listeners.addAll(listeners);
  }

  @Override
  public void onConnect(OBSCommunicator communicator, Session session) {
    listeners.forEach(
      it -> it.onConnect(communicator, session)
    );
  }

  @Override
  public void onHello(OBSCommunicator communicator, Hello hello) {
    listeners.forEach(it -> it.onHello(communicator, hello));
  }

  @Override
  public void onIdentified(OBSCommunicator communicator,
    Identified identified) {
    listeners.forEach(it -> it.onIdentified(communicator, identified));
  }

  @Override
  public void onClose(OBSCommunicator communicator,
    CodeReason codeReason) {
    listeners.forEach(it -> it.onClose(communicator, codeReason));
  }

  @Override
  public void onError(OBSCommunicator communicator,
    ReasonThrowable reasonThrowable) {
    listeners.forEach(it -> it.onError(communicator, reasonThrowable));
  }
}
