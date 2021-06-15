package net.twasi.obsremotejava.listener.lifecycle.controller;

import net.twasi.obsremotejava.OBSRemoteController;
import net.twasi.obsremotejava.listener.lifecycle.ReasonThrowable;

public interface ControllerLifecycleListener {
  void onReady(OBSRemoteController controller);
  void onDisconnect(OBSRemoteController controller);
  void onError(OBSRemoteController controller, ReasonThrowable reasonThrowable);
}
