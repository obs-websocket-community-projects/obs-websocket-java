package io.obswebsocket.community.client.listener.lifecycle.controller;

import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingControllerLifecycleListener implements ControllerLifecycleListener {

  @Override
  public void onError(ReasonThrowable reasonThrowable) {
    log.error(reasonThrowable.getReason(), reasonThrowable.getThrowable());
  }
}
