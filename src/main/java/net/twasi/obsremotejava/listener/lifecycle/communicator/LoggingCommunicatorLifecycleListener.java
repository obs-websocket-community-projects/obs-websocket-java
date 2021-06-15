package net.twasi.obsremotejava.listener.lifecycle.communicator;

import lombok.extern.slf4j.Slf4j;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.listener.lifecycle.ReasonThrowable;
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
public class LoggingCommunicatorLifecycleListener implements CommunicatorLifecycleListener {

  @Override
  public void onConnect(OBSCommunicator communicator, Session session) {
    log.debug("onConnect: " + session);
  }

  @Override
  public void onHello(OBSCommunicator communicator, Hello hello) {
    log.debug("onHello: " + hello);
  }

  @Override
  public void onIdentified(OBSCommunicator communicator,
    Identified identified) {
    log.debug("onIdentified: " + identified);
  }

  @Override
  public void onClose(OBSCommunicator communicator,
    CodeReason codeReason) {
    log.info(String.format("Connection closed: %d - %s%n", codeReason.getCode(), codeReason.getReason()));
  }

  @Override
  public void onError(OBSCommunicator communicator,
    ReasonThrowable reasonThrowable) {
    log.error("onError: " + reasonThrowable.getReason(), reasonThrowable.getThrowable());
  }

}
