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
  public void onIdentified(OBSCommunicator communicator,
    Identified identified) {
    listeners.forEach(it -> it.onIdentified(communicator, identified));
  }

  @Override
  public void onClose(Integer code, String reason) {
    listeners.forEach(it -> it.onClose(code, reason));
  }

  @Override
  public void onError(String reason, Throwable throwable) {
    listeners.forEach(it -> it.onError(reason, throwable));
  }
}
