package net.twasi.obsremotejava.listener.lifecycle;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Identified;
import org.eclipse.jetty.websocket.api.Session;

public interface LifecycleListener {
  void onConnect(Session session);
  void onHello(Hello hello);
  void onIdentified(OBSCommunicator communicator, Identified identified);
  void onClose(Integer code, String reason);
  void onError(String reason, Throwable throwable);
}
