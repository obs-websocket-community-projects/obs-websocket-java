package io.obswebsocket.community.client;

import com.google.gson.JsonSyntaxException;
import io.obswebsocket.community.client.authenticator.Authenticator;
import io.obswebsocket.community.client.listener.event.ObsEventListener;
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
import io.obswebsocket.community.client.message.request.general.GetVersionRequest;
import io.obswebsocket.community.client.message.response.RequestBatchResponse;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.message.response.general.GetVersionResponse;
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

@Slf4j
@WebSocket(maxTextMessageSize = 1024 * 1024, maxIdleTime = 360000000)
public class OBSCommunicator {

  public static final Integer RPC_VERSION = 1;

  private final CountDownLatch closeLatch = new CountDownLatch(1);

  private final MessageTranslator translator;
  private final Authenticator authenticator;

  private final ObsEventListener obsEventListener;
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
      ObsEventListener obsEventListener) {
    this.translator = translator;
    this.authenticator = authenticator;
    this.communicatorLifecycleListener = communicatorLifecycleListener;
    this.obsRequestListener = obsRequestListener;
    this.obsEventListener = obsEventListener;
  }

  public static ObsCommunicatorBuilder builder() {
    return new ObsCommunicatorBuilder();
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
  public boolean awaitClose(int duration, TimeUnit unit) throws InterruptedException {
    return this.closeLatch.await(duration, unit);
  }

  /**
   * TODO: Add await description
   *
   * @throws InterruptedException if couldn't wait
   */
  public void await() throws InterruptedException {
    this.closeLatch.await();
  }

  @OnWebSocketError
  public void onError(Session session, Throwable t) {
    this.communicatorLifecycleListener
        .onError(this, new ReasonThrowable(
            "Websocket error occurred with session " + session, t
        ));
    if (this.session != null) {
      this.session.close(4000, "An exception was thrown with message: " + t.getMessage());
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
          "onClose called with unrecognized statusCode %n and reason '%s'",
          statusCode,
          reason
      ));
    }
    this.communicatorLifecycleListener.onClose(this, webSocketCloseCode);
    this.closeLatch.countDown();
    this.communicatorLifecycleListener.onDisconnect(this);
  }

  @OnWebSocketConnect
  public void onConnect(Session session) {
    this.session = session;
    try {
      this.communicatorLifecycleListener.onConnect(this, this.session);
    } catch (Throwable t) {
      this.communicatorLifecycleListener.onError(this, new ReasonThrowable(
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
        switch (message.getMessageType()) {
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
            this.communicatorLifecycleListener.onError(this, new ReasonThrowable(
                "Invalid response type received", null
            ));
        }
      } else {
        this.communicatorLifecycleListener
            .onError(this, new ReasonThrowable(
                "Received message was deserializable but had unknown format", null
            ));
      }
    } catch (JsonSyntaxException jsonSyntaxException) {
      this.communicatorLifecycleListener
          .onError(this, new ReasonThrowable(
              "Message received was not valid json: " + msg, jsonSyntaxException
          ));
    } catch (Throwable t) {
      this.communicatorLifecycleListener
          .onError(this, new ReasonThrowable(
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
      obsEventListener.onEvent(event);
    } catch (Throwable t) {
      this.communicatorLifecycleListener
          .onError(this, new ReasonThrowable(
              "Failed to execute callback for Event: " + event.getEventType(), t
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
      obsRequestListener.onRequestResponse(requestResponse);
    } catch (Throwable t) {
      this.communicatorLifecycleListener.onError(this, new ReasonThrowable(
          "Failed to execute callback for RequestResponse: " + requestResponse.getRequestType(), t
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
      obsRequestListener.onRequestBatchResponse(requestBatchResponse);
    } catch (Throwable t) {
      this.communicatorLifecycleListener.onError(this, new ReasonThrowable(
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
        hello.getRpcVersion(),
        hello.isAuthenticationRequired()
    ));

    // If RPC version doesn't match, then the protocol isn't supported
    if (hello.getRpcVersion() < RPC_VERSION) {
      this.onError(session, new IllegalStateException(
          "Server doesn't support this client's RPC version"
      ));
      return;
    }

    // Build the identify response
    Identify.IdentifyBuilder identifyBuilder = Identify.builder()
        .rpcVersion(RPC_VERSION);

    // Add subscription
    identifyBuilder.eventSubscriptions(obsEventListener.computeEventSubscription());

    // Add authentication, if required
    if (hello.isAuthenticationRequired()) {
      // Build the authentication string
      String authentication = this.authenticator.computeAuthentication(
          hello.getAuthentication().getSalt(),
          hello.getAuthentication().getChallenge()
      );
      identifyBuilder.authentication(authentication);
    }

    // Send the response
    this.communicatorLifecycleListener.onHello(this, hello);
    this.sendMessage(identifyBuilder.build());
  }

  /**
   * Sent from server on successful authentication/connection
   *
   * @param identified {@link Identified}
   */
  public void onIdentified(Identified identified) {
    log.info("Identified by OBS, ready to accept requests");
    this.communicatorLifecycleListener.onIdentified(this, identified);

    this.sendRequest(GetVersionRequest.builder().build(),
        (GetVersionResponse getVersionResponse) -> {
          log.info(String.format("Using OBS %s and Websockets version %s",
              getVersionResponse.getResponseData().getObsVersion(),
              getVersionResponse.getResponseData().getObsWebSocketVersion()));
        });

    this.communicatorLifecycleListener.onReady(this);
  }

  /**
   * An internal convenience method to centralize outbound calls to OBS for e.g. logging purposes.
   *
   * @param message message to send (e.g. a JSON object)
   */
  private void send(String message) {
    log.debug("Sent message     >>\n" + message);
    if (this.session == null) {
      communicatorLifecycleListener.onError(this, new ReasonThrowable(
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
    obsRequestListener.registerRequest(request, callback);
    this.sendMessage(request);
  }

  /**
   * Send a {@link RequestBatch} and register a {@link RequestBatchResponse} callback
   *
   * @param requestBatch {@link RequestBatch}
   * @param callback     {@link RequestBatchResponse}
   */
  public void sendRequestBatch(RequestBatch requestBatch, Consumer<RequestBatchResponse> callback) {
    if (requestBatch.getRequests() != null && !requestBatch.getRequests().isEmpty()) {
      obsRequestListener.registerRequestBatch(requestBatch, callback);
      this.sendMessage(requestBatch);
    } else {
      throw new IllegalArgumentException("A RequestBatch must contain at least 1 request");
    }
  }
}
