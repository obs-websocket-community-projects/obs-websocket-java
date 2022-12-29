package io.obswebsocket.community.client;

import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.listener.lifecycle.controller.ControllerLifecycleListener;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestBatch;
import io.obswebsocket.community.client.message.response.RequestBatchResponse;
import io.obswebsocket.community.client.message.response.RequestResponse;
import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

/**
 * This is the main entrypoint for the client. It provides methods for making requests against OBS
 * Websocket, and its builder (${@link OBSRemoteControllerBuilder}) provides methods to register OBS
 * Websocket event listeners and lifecycle callbacks for this client (see
 * ${@link
 * io.obswebsocket.community.client.listener.lifecycle.communicator.CommunicatorLifecycleListener}
 * and ${@link ControllerLifecycleListener} for more information on these lifecycle callbacks).
 */
@Slf4j
public class OBSRemoteController extends OBSRemoteControllerBase {

  private final URI uri;
  private final OBSCommunicator communicator;
  private final WebSocketClient webSocketClient;
  private final int connectionTimeoutSeconds;

  private final ControllerLifecycleListener controllerLifecycleListener;

  /**
   * All-Args constructor, used by the builder or directly.
   *
   * @param webSocketClient             WebSocketClient instance.
   * @param communicator                Instance of {@link OBSCommunicator} (annotated websocket
   *                                    listener).
   * @param controllerLifecycleListener Instance of {@link ControllerLifecycleListener}
   * @param host                        OBS Host,
   * @param port                        OBS port.
   * @param connectionTimeoutSeconds    Seconds timeout while trying to make first connection to
   *                                    OBS. Must be greater than zero.
   * @param autoConnect                 If true, will connect after this class is instantiated.
   */
  public OBSRemoteController(
      WebSocketClient webSocketClient,
      OBSCommunicator communicator,
      ControllerLifecycleListener controllerLifecycleListener,
      String host,
      int port,
      int connectionTimeoutSeconds,
      boolean autoConnect) {
    if (connectionTimeoutSeconds < 0) {
      throw new IllegalArgumentException("Connection timeout must be greater than zero");
    }
    this.webSocketClient = webSocketClient;
    this.communicator = communicator;
    this.controllerLifecycleListener = controllerLifecycleListener;
    try {
      this.uri = new URI("ws://" + host + ":" + port);
    } catch (URISyntaxException e) {
      throw new IllegalArgumentException("Host or Port are invalid");
    }
    this.connectionTimeoutSeconds = connectionTimeoutSeconds;
    if (autoConnect) {
      this.connect();
    }
  }

  public static OBSRemoteControllerBuilder builder() {
    return new OBSRemoteControllerBuilder();
  }

  public void connect() {
    try {
      this.webSocketClient.start();
      // Create a new upgrade request, start the client, and connect
      // Note that start() must have been called, otherwise an exception
      // is thrown when connect is called.
      ClientUpgradeRequest clientUpgradeRequest = new ClientUpgradeRequest();
      Future<Session> connection = this.webSocketClient.connect(
          this.communicator, this.uri, clientUpgradeRequest
      );
      log.debug(String.format("Connecting to: %s", this.uri));

      // Block on the connection succeeding
      connection.get(this.connectionTimeoutSeconds, TimeUnit.SECONDS);
    } catch (Throwable t) {
      // If the exception is caused by OBS being unavailable over the network
      // (or not installed or started), then call onError with helpful message
      if (
          t instanceof TimeoutException
              || (t instanceof ExecutionException && t.getCause() != null && t
                .getCause() instanceof ConnectException)
              || (t instanceof ExecutionException && t.getCause() != null && t
                .getCause() instanceof UnknownHostException)
      ) {
        this.controllerLifecycleListener.onError(
            new ReasonThrowable("Could not contact OBS on: " + this.uri
                + ", verify OBS is running, the plugin is installed, and it can be reached over the network",
                t.getCause() == null ? t : t.getCause()
            )
        );
      }
      // Otherwise, something unexpected has happened during connect
      else {
        this.controllerLifecycleListener.onError(
            new ReasonThrowable("An unexpected exception occurred during connect", t)
        );
      }
    }
  }

  public void disconnect() {
    // trigger the latch
    try {
      log.debug("Closing connection.");
      this.communicator.closeAndAwait(this.connectionTimeoutSeconds, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      this.controllerLifecycleListener.onError(
          new ReasonThrowable("Error during closing websocket connection", e)
      );
    }
    finally {
      try {
        log.debug("Stopping client.");
        this.webSocketClient.stop();
      } catch (Exception e) {
        this.controllerLifecycleListener.onError(
            new ReasonThrowable("Error during stopping websocket client", e)
        );
      }
    }
  }

  /**
   * Send a Request
   *
   * @param request  R
   * @param callback Consumer&lt;RR&gt;
   * @param <R>      extends {@link Request}
   * @param <RR>     extends {@link RequestResponse}
   */
  public <R extends Request, RR extends RequestResponse> void sendRequest(R request,
      Consumer<RR> callback) {
    this.communicator.sendRequest(request, callback);
  }

  /**
   * Send a RequestBatch
   *
   * @param requestBatch {@link RequestBatch}
   * @param callback     Consumer&lt;{@link RequestBatchResponse}&gt;
   */
  public void sendRequestBatch(RequestBatch requestBatch, Consumer<RequestBatchResponse> callback) {
    this.communicator.sendRequestBatch(requestBatch, callback);
  }
}
