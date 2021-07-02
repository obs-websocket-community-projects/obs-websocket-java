package io.obswebsocket.community.client.listener.lifecycle.communicator;

import io.obswebsocket.community.client.OBSCommunicator;
import io.obswebsocket.community.client.OBSRemoteController;
import io.obswebsocket.community.client.WebSocketCloseCode;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.message.authentication.Hello;
import io.obswebsocket.community.client.message.authentication.Identified;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.eclipse.jetty.websocket.api.Session;

/**
 * A listener that is invoked by the ${@link io.obswebsocket.community.client.OBSCommunicator} on
 * each respective event.
 */
public interface CommunicatorLifecycleListener {

  /**
   * Invoked when an initial connection has been established to OBS Websocket, before the client
   * has been identified and permitted to make further requests.
   */
  void onConnect(OBSCommunicator communicator, Session session);

  /**
   * Invoked when OBS Websocket has sent the initial information required to authenticate.
   * @see <a href="https://github.com/Palakis/obs-websocket/blob/master/docs/generated/protocol.md">OBS Websocket V5 Protocol</a>
   */
  void onHello(OBSCommunicator communicator, Hello hello);

  /**
   * Invoked when OBS Websocket has accepted the client's auth response (Identify).
   * @see <a href="https://github.com/Palakis/obs-websocket/blob/master/docs/generated/protocol.md">OBS Websocket V5 Protocol</a>
   */
  void onIdentified(OBSCommunicator communicator, Identified identified);

  /**
   * Invoked when the client is now ready to accept requests; it has been identified by OBS
   * Websocket and any other startup activities have completed.
   */
  void onReady(OBSCommunicator communicator);

  /**
   * Invoked when OBS Websocket has closed the connection; this will occur either if authentication
   * fails, an error has occurred, or the client was told by the user to close the connection.
   * @see <a href="https://github.com/Palakis/obs-websocket/blob/master/docs/generated/protocol.md">OBS Websocket V5 Protocol</a>
   */
  void onClose(OBSCommunicator communicator, WebSocketCloseCode webSocketCloseCode);

  /**
   * Invoked when the client has fully disconnected from OBS Websocket, and reconnect can be
   * attempted again.
   */
  void onDisconnect(OBSCommunicator communicator);

  /**
   * Invoked when an exceptional condition has occurred during client runtime, generally reserved
   * for unexpected exceptions such as NullPointerException and the like.
   * @param communicator
   * @param reasonThrowable
   */
  void onError(OBSCommunicator communicator, ReasonThrowable reasonThrowable);

}
