package io.obswebsocket.community.client.listener.lifecycle.communicator;

import io.obswebsocket.community.client.OBSCommunicator;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.message.authentication.Hello;
import io.obswebsocket.community.client.message.authentication.Identified;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
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
