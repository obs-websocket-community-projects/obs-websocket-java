package net.twasi.obsremotejava.listener.lifecycle.communicator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.listener.lifecycle.ReasonThrowable;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Identified;
import org.eclipse.jetty.websocket.api.Session;

public interface CommunicatorLifecycleListener {
  void onConnect(OBSCommunicator communicator, Session session);
  void onHello(OBSCommunicator communicator, Hello hello);
  void onIdentified(OBSCommunicator communicator, Identified identified);
  void onClose(OBSCommunicator communicator, CodeReason codeReason);
  void onError(OBSCommunicator communicator, ReasonThrowable reasonThrowable);

  @ToString
  @Getter
  @AllArgsConstructor
  public static class CodeReason {
    private final Integer code;
    private final String reason;
  }

}
