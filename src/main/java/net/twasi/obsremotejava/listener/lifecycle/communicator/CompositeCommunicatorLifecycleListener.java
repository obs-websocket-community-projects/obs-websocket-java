package net.twasi.obsremotejava.listener.lifecycle.communicator;

import java.util.ArrayList;
import java.util.List;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.listener.lifecycle.ReasonThrowable;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Identified;
import org.eclipse.jetty.websocket.api.Session;

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
