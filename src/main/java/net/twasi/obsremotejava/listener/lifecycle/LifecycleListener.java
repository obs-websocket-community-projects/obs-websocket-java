package net.twasi.obsremotejava.listener.lifecycle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Identified;
import org.eclipse.jetty.websocket.api.Session;

public interface LifecycleListener<C> {
  void onConnect(C communicator, Session session);
  void onHello(C communicator, Hello hello);
  void onIdentified(C communicator, Identified identified);
  void onClose(C communicator,
    CodeReason codeReason);
  void onError(C communicator,
    ReasonThrowable reasonThrowable);

  @ToString
  @Getter
  @AllArgsConstructor
  public static class CodeReason {
    private final Integer code;
    private final String reason;
  }

  @ToString
  @Getter
  @AllArgsConstructor
  public static class ReasonThrowable {
    private final String reason;
    private final Throwable throwable;
  }
}
