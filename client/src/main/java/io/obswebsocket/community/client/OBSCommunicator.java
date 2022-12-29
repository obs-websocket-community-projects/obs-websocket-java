package io.obswebsocket.community.client;

import com.google.gson.JsonSyntaxException;
import io.obswebsocket.community.client.authenticator.Authenticator;
import io.obswebsocket.community.client.listener.event.OBSEventListener;
import io.obswebsocket.community.client.listener.lifecycle.ReasonThrowable;
import io.obswebsocket.community.client.listener.lifecycle.communicator.CommunicatorLifecycleListener;
import io.obswebsocket.community.client.listener.request.ObsRequestListener;
import io.obswebsocket.community.client.message.Message;
import io.obswebsocket.community.client.message.authentication.Hello;
import io.obswebsocket.community.client.message.authentication.Identified;
import io.obswebsocket.community.client.message.authentication.Identify;
import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestBatch;
import io.obswebsocket.community.client.message.response.RequestBatchResponse;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.translator.MessageTranslator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

/**
 * An annotated websocket listener that accepts callbacks for standard websocket callbacks (connect,
 * message, close), callbacks specific to OBS Websocket (hello, identified, event, etc), and for
 * lifecycle events specific to this client library (ready, disconnect). See
 * ${@link CommunicatorLifecycleListener} for more information.
 * <p>
 * This class is internal to this library and should not be used directly; please use
 * ${@link OBSRemoteController} for requests and ${@link OBSRemoteController#builder()} to register
 * lifecycle custom callbacks/listeners.
 */
@Slf4j
@WebSocket(
    maxTextMessageSize = 1024 * 1024,
    maxIdleTime = 360000000
)
public class OBSCommunicator {

  public static final Integer RPC_VERSION = 1;

  private final CountDownLatch closeLatch = new CountDownLatch(1);

  private final MessageTranslator translator;
  private final Authenticator authenticator;

  private final OBSEventListener obsEventListener;
  private final ObsRequestListener obsRequestListener;

  private Session session;

  private final CommunicatorLifecycleListener communicatorLifecycleListener;

  /**
   * All-args constructor used by the builder class.
   *
   * @param translator                    GSON instance
   * @param authenticator                 Authenticator instance; NoOpAuthenticator if no password,
   *                                      otherwise AuthenticatorImpl.
   * @param communicatorLifecycleListener {@link CommunicatorLifecycleListener}
   * @param obsRequestListener            Responsible for processing incoming requestResponses the
   *                                      client is waiting.
   * @param obsEventListener              Responsible for processing incoming events the client has
   *                                      subscribed to.
   */
  public OBSCommunicator(
      MessageTranslator translator,
      Authenticator authenticator,
      CommunicatorLifecycleListener communicatorLifecycleListener,
      ObsRequestListener obsRequestListener,
      OBSEventListener obsEventListener) {
    this.translator = translator;
    this.authenticator = authenticator;
    this.communicatorLifecycleListener = communicatorLifecycleListener;
    this.obsRequestListener = obsRequestListener;
    this.obsEventListener = obsEventListener;
  }

  public static OBSCommunicatorBuilder builder() {
    return new OBSCommunicatorBuilder();
  }

  /**
   * TODO: add awaitClose description
   *
   * @param duration int
   * @param unit     TimeUnit
   * @return true if the count reached zero and false if the waiting time elapsed before the count
   * reached zero
   * @throws InterruptedException if couldn't wait
   */
  public boolean closeAndAwait(int duration, TimeUnit unit) throws InterruptedException {
    if (this.session != null) {
      this.session.close();
      this.session = null;
    }

    return this.closeLatch.await(duration, unit);
  }

  @OnWebSocketError
  public void onError(Session session, Throwable t) {
    this.communicatorLifecycleListener
        .onError(new ReasonThrowable(
            "Websocket error occurred with session " + session, t
        ));
    if (this.session != null) {
      this.session.close(4000, "An exception was thrown with message: " + t.getMessage());
      this.session = null;
    }
  }

  @OnWebSocketClose
  public void onClose(int statusCode, String reason) {
    // An unknown code shouldn't cause a breaking exception, but should be warned/logged
    WebSocketCloseCode webSocketCloseCode = WebSocketCloseCode.UnknownCode;
    try {
      webSocketCloseCode = WebSocketCloseCode.fromCode(statusCode);
    } catch (IllegalArgumentException e) {
      log.warn(String.format(
          "onClose called with unrecognized statusCode %s and reason '%s'",
          statusCode,
          reason
      ));
    }
    this.communicatorLifecycleListener.onClose(webSocketCloseCode);
    this.closeLatch.countDown();
    this.session = null;
    this.communicatorLifecycleListener.onDisconnect();
  }

  @OnWebSocketConnect
  public void onConnect(Session session) {
    this.session = session;
    try {
      this.communicatorLifecycleListener.onConnect(this.session);
    } catch (Throwable t) {
      this.communicatorLifecycleListener.onError(new ReasonThrowable(
          "An error occurred while trying to get a session", t
      ));
    }
  }

  @OnWebSocketMessage
  public void onMessage(String msg) {
    log.debug("Received message <<\n" + msg);

    try {
      Message message = this.translator.fromJson(msg, Message.class);
      if (message != null) {
        switch (message.getOperationCode()) {
          case Event:
            this.onEvent((Event) message);
            break;

          case RequestResponse:
            this.onRequestResponse((RequestResponse) message);
            break;

          case RequestBatchResponse:
            this.onRequestBatchResponse((RequestBatchResponse) message);
            break;

          case Hello:
            this.onHello((Hello) message);
            break;

          case Identified:
            this.onIdentified((Identified) message);
            break;

          default:
            this.communicatorLifecycleListener.onError(new ReasonThrowable(
                "Invalid response type received", null
            ));
        }
      } else {
        this.communicatorLifecycleListener
            .onError(new ReasonThrowable(
                "Received message was deserializable but had unknown format", null
            ));
      }
    } catch (JsonSyntaxException jsonSyntaxException) {
      this.communicatorLifecycleListener
          .onError(new ReasonThrowable(
              "Message received was not valid json: " + msg, jsonSyntaxException
          ));
    } catch (Throwable t) {
      this.communicatorLifecycleListener
          .onError(new ReasonThrowable(
              "Failed to process message from websocket due to unexpected exception", t
          ));
    }
  }

  /**
   * Internal callback when a {@link Event} is received
   *
   * @param event {@link Event}
   */
  private void onEvent(Event event) {
    try {
      this.obsEventListener.onEvent(event);
    } catch (Throwable t) {
      this.communicatorLifecycleListener
          .onError(new ReasonThrowable(
              "Failed to execute callback for Event: " + event.getMessageData().getEventType(), t
          ));
    }
  }

  /**
   * Internal callback when a {@link RequestResponse} is received
   *
   * @param requestResponse {@link RequestResponse}
   */
  private void onRequestResponse(RequestResponse requestResponse) {
    try {
      this.obsRequestListener.onRequestResponse(requestResponse);
    } catch (Throwable t) {
      this.communicatorLifecycleListener.onError(new ReasonThrowable(
          "Failed to execute callback for RequestResponse: " + requestResponse.getMessageData()
              .getRequestType(), t
      ));
    }
  }

  /**
   * Internal callback when a {@link RequestBatchResponse} is received
   *
   * @param requestBatchResponse {@link RequestBatchResponse}
   */
  private void onRequestBatchResponse(RequestBatchResponse requestBatchResponse) {
    try {
      this.obsRequestListener.onRequestBatchResponse(requestBatchResponse);
    } catch (Throwable t) {
      this.communicatorLifecycleListener.onError(new ReasonThrowable(
          "Failed to execute callback for RequestBatchResponse: " + requestBatchResponse, t
      ));
    }
  }

  /**
   * First response from server when reached; contains authentication info if required to connect.
   *
   * @param hello {@link Hello}
   */
  public void onHello(Hello hello) {

    log.debug(String.format(
        "Rpc version %s. Authentication is required: %s",
        hello.getMessageData().getRpcVersion(),
        hello.isAuthenticationRequired()
    ));

    // If RPC version doesn't match, then the protocol isn't supported
    if (hello.getMessageData().getRpcVersion() < RPC_VERSION) {
      this.onError(this.session, new IllegalStateException(
          "Server doesn't support this client's RPC version"
      ));
      return;
    }

    // Build the identify response
    Identify.IdentifyBuilder identifyBuilder = Identify.builder()
        .rpcVersion(RPC_VERSION);

    // Add subscription
    identifyBuilder.eventSubscriptions(this.obsEventListener.computeEventSubscription());

    // Add authentication, if required
    if (hello.isAuthenticationRequired()) {
      // Build the authentication string
      String authentication = this.authenticator.computeAuthentication(
          hello.getMessageData().getAuthentication().getSalt(),
          hello.getMessageData().getAuthentication().getChallenge()
      );
      identifyBuilder.authentication(authentication);
    }

    // Send the response
    this.communicatorLifecycleListener.onHello(hello);
    this.sendMessage(identifyBuilder.build());
  }

  /**
   * Sent from server on successful authentication/connection
   *
   * @param identified {@link Identified}
   */
  public void onIdentified(Identified identified) {
    this.communicatorLifecycleListener.onIdentified(identified);

    this.communicatorLifecycleListener.onReady();
  }

  /**
   * An internal convenience method to centralize outbound calls to OBS for e.g. logging purposes.
   *
   * @param message message to send (e.g. a JSON object)
   */
  private void send(String message) {
    log.debug("Sent message     >>\n" + message);
    if (this.session == null) {
      this.communicatorLifecycleListener.onError(new ReasonThrowable(
          "Could not send message; no session established",
          null
      ));
    } else {
      this.session.getRemote().sendStringByFuture(message);
    }
  }

  /**
   * Internal send Message
   *
   * @param message {@link Message}
   */
  private void sendMessage(Message message) {
    this.send(this.translator.toJson(message));
  }

  /**
   * Send a {@link Request} and register a {@link RequestResponse} callback
   *
   * @param request  R
   * @param callback Consumer&lt;RR&gt;
   * @param <R>      extends {@link Request}
   * @param <RR>     extends {@link RequestResponse}
   */
  public <R extends Request, RR extends RequestResponse> void sendRequest(R request,
      Consumer<RR> callback) {
    this.obsRequestListener.registerRequest(request, callback);
    this.sendMessage(request);
  }

  /**
   * Send a {@link RequestBatch} and register a {@link RequestBatchResponse} callback
   *
   * @param requestBatch {@link RequestBatch}
   * @param callback     {@link RequestBatchResponse}
   */
  public void sendRequestBatch(RequestBatch requestBatch, Consumer<RequestBatchResponse> callback) {
    if (requestBatch.getData().getRequests() != null && !requestBatch.getData().getRequests()
        .isEmpty()) {
      this.obsRequestListener.registerRequestBatch(requestBatch, callback);
      this.sendMessage(requestBatch);
    } else {
      throw new IllegalArgumentException("A RequestBatch must contain at least 1 request");
    }
  }
}
