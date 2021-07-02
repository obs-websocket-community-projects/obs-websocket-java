package io.obswebsocket.community.client;

import java.util.Arrays;

public enum WebSocketCloseCode {
  // For unknown status codes
  UnknownCode(-1),
  // Internal only
  DontClose(0),
  // Reserved
  UnknownReason(4000),
  // The server was unable to decode the incoming websocket message
  MessageDecodeError(4001),
  // The specified `messageType` was invalid or missing
  UnknownMessageType(4002),
  // The client sent a websocket message without first sending `Identify` message
  NotIdentified(4003),
  // The client sent an `Identify` message while already identified
  AlreadyIdentified(4004),
  // The authentication attempt (via `Identify`), failed
  AuthenticationFailed(4005),
  // There was an invalid parameter the client's `Identify` message
  InvalidIdentifyParameter(4006),
  // A `Request` or `RequestBatch` was missing its `requestId` or `requestType`
  RequestMissingRequiredField(4007),
  // The websocket session has been invalidated by the obs-websocket server.
  SessionInvalidated(4008),
  // The server detected the usage of an old version of the obs-websocket protocol.
  UnsupportedProtocolVersion(4009),
  // The requested `Content-Type` specified in the request HTTP header is invalid.
  InvalidContentType(4010);

  private final int code;

  private WebSocketCloseCode(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  public static WebSocketCloseCode fromCode(int code) {
    return Arrays.stream(WebSocketCloseCode.values())
        .filter(it -> it.getCode() == code)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Code is invalid"));
  }

}