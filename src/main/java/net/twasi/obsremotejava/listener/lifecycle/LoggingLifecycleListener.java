package net.twasi.obsremotejava.listener.lifecycle;

import lombok.extern.slf4j.Slf4j;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Identified;
import org.eclipse.jetty.websocket.api.Session;

/**
 * Lifecycle Listener that logs all calls.
 *  - onClose is always at INFO
 *  - onError is always at ERROR
 *  - all others are at DEBUG
 */
@Slf4j
public class LoggingLifecycleListener implements LifecycleListener {

  public void onConnect(Session session) {
    log.debug("onConnect: " + session);
  }

  public void onHello(Hello hello) {
    log.debug("onHello: " + hello);
  }

  public void onIdentified(OBSCommunicator communicator,
    Identified identified) {
    log.debug("onIdentified: " + identified);
  }

  public void onClose(Integer code, String reason) {
    log.info(String.format("Connection closed: %d - %s%n", code, reason));
  }

  public void onError(String reason, Throwable throwable) {
    log.error("onError: " + reason, throwable);
  }

}
