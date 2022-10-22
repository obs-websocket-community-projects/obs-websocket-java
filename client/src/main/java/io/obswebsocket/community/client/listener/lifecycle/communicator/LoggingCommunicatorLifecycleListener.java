package io.obswebsocket.community.client.listener.lifecycle.communicator;

import io.obswebsocket.community.client.WebSocketCloseCode;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.message.authentication.Hello;
import io.obswebsocket.community.client.message.authentication.Identified;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.websocket.api.Session;

/**
 * Lifecycle Listener that logs all calls. - onClose is always at INFO - onError is always at ERROR
 * - all others are at DEBUG
 */
@Slf4j
public class LoggingCommunicatorLifecycleListener implements CommunicatorLifecycleListener {

  @Override
  public void onConnect(Session session) {
    log.info("Connected to OBS at: " + session.getRemoteAddress());
  }

  @Override
  public void onHello(Hello hello) {
    log.debug("onHello: " + hello);
  }

  @Override
  public void onIdentified(Identified identified) {
    log.debug("onIdentified: " + identified);
  }

  @Override
  public void onReady() {
    log.info("Client is ready to accept requests");
  }

  @Override
  public void onClose(WebSocketCloseCode webSocketCloseCode) {
    log.info(String.format("Connection closed: %d - %s%n",
        webSocketCloseCode.getCode(), webSocketCloseCode.name()));
  }

  @Override
  public void onDisconnect() {
    log.info("Client is now disconnected");
  }

  @Override
  public void onError(ReasonThrowable reasonThrowable) {
    log.error("onError: " + reasonThrowable.getReason(), reasonThrowable.getThrowable());
  }

}
