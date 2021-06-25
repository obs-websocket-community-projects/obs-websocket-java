package io.obswebsocket.community.client.listener.lifecycle.communicator;

import io.obswebsocket.community.client.OBSCommunicator;
import io.obswebsocket.community.client.message.authentication.Hello;
import io.obswebsocket.community.client.message.authentication.Identified;
import lombok.extern.slf4j.Slf4j;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
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
