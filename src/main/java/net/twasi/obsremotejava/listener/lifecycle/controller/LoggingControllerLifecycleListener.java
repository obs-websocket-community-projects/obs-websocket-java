package net.twasi.obsremotejava.listener.lifecycle.controller;

import lombok.extern.slf4j.Slf4j;
import net.twasi.obsremotejava.OBSRemoteController;
import net.twasi.obsremotejava.listener.lifecycle.ReasonThrowable;

@Slf4j
public class LoggingControllerLifecycleListener implements ControllerLifecycleListener {

  @Override
  public void onReady(OBSRemoteController controller) {
    log.info("OBS RemoteController is ready");
  }

  @Override
  public void onDisconnect(OBSRemoteController controller) {
    log.info("OBS RemoteController has disconnected");
  }

  @Override
  public void onError(OBSRemoteController controller, ReasonThrowable reasonThrowable) {
    log.error(reasonThrowable.getReason(), reasonThrowable.getThrowable());
  }
}
