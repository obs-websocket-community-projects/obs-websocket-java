package net.twasi.obsremotejava.listener.lifecycle;

import java.util.ArrayList;
import java.util.List;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Identified;
import org.eclipse.jetty.websocket.api.Session;

/**
 * Lifecycle listener that executes other lifecycle listeners in the order received.
 */
public class CompositeLifecycleListener implements LifecycleListener {

  private final List<LifecycleListener> listeners = new ArrayList<>();

  public CompositeLifecycleListener(List<LifecycleListener> listeners) {
    if(listeners != null) this.listeners.addAll(listeners);
  }

  @Override
  public void onConnect(Object communicator, Session session) {
    listeners.forEach(
      it -> it.onConnect(communicator, session)
    );
  }

  @Override
  public void onHello(Object communicator, Hello hello) {
    listeners.forEach(it -> it.onHello(communicator, hello));
  }

  @Override
  public void onIdentified(Object communicator,
    Identified identified) {
    listeners.forEach(it -> it.onIdentified(communicator, identified));
  }

  @Override
  public void onClose(Object communicator,
    CodeReason codeReason) {
    listeners.forEach(it -> it.onClose(communicator, codeReason));
  }

  @Override
  public void onError(Object communicator,
    ReasonThrowable reasonThrowable) {
    listeners.forEach(it -> it.onError(communicator, reasonThrowable));
  }
}
