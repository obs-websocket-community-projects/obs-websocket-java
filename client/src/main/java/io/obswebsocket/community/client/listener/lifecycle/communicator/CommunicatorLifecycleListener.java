package io.obswebsocket.community.client.listener.lifecycle.communicator;

import io.obswebsocket.community.client.WebSocketCloseCode;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.message.authentication.Hello;
import io.obswebsocket.community.client.message.authentication.Identified;
import org.eclipse.jetty.websocket.api.Session;

/**
 * A listener that is invoked by the ${@link io.obswebsocket.community.client.OBSCommunicator} on
 * each respective event.
 */
public interface CommunicatorLifecycleListener {

  /**
   * Invoked when an initial connection has been established to OBS Websocket, before the client has
   * been identified and permitted to make further requests.
   *
   * @param session {@link Session}
   */
  void onConnect(Session session);

  /**
   * Invoked when OBS Websocket has sent the initial information required to authenticate.
   *
   * @param hello {@link Hello}
   * @see <a href="https://github.com/obsproject/obs-websocket/blob/master/docs/generated/protocol.md">OBS
   * Websocket V5 Protocol</a>
   */
  void onHello(Hello hello);

  /**
   * Invoked when OBS Websocket has accepted the client's auth response (Identify).
   *
   * @param identified {@link Identified}
   * @see <a href="https://github.com/obsproject/obs-websocket/blob/master/docs/generated/protocol.md">OBS
   * Websocket V5 Protocol</a>
   */
  void onIdentified(Identified identified);

  /**
   * Invoked when the client is now ready to accept requests; it has been identified by OBS
   * Websocket and any other startup activities have completed.
   */
  void onReady();

  /**
   * Invoked when OBS Websocket has closed the connection; this will occur either if authentication
   * fails, an error has occurred, or the client was told by the user to close the connection.
   *
   * @param webSocketCloseCode {@link WebSocketCloseCode}
   * @see <a href="https://github.com/obsproject/obs-websocket/blob/master/docs/generated/protocol.md">OBS
   * Websocket V5 Protocol</a>
   */
  void onClose(WebSocketCloseCode webSocketCloseCode);

  /**
   * Invoked when the client has fully disconnected from OBS Websocket, and reconnect can be
   * attempted again.
   */
  void onDisconnect();

  /**
   * Invoked when an exceptional condition has occurred during client runtime, generally reserved
   * for unexpected exceptions such as NullPointerException and the like.
   *
   * @param reasonThrowable {@link ReasonThrowable}
   */
  void onError(ReasonThrowable reasonThrowable);

}
