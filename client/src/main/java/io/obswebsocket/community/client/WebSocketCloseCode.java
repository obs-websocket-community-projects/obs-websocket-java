package io.obswebsocket.community.client;

import java.util.Arrays;

public enum WebSocketCloseCode {
  /**
   * For unknown status codes
   */
  UnknownCode(-1),
  /**
   * Internal only
   */
  DontClose(0),
  /**
   * Reserved
   */
  UnknownReason(4000),
  /**
   * The server was unable to decode the incoming websocket message
   */
  MessageDecodeError(4002),
  /**
   * A data key is missing but required
   */
  MissingDataKey(4003),
  /**
   * A data key has an invalid type
   */
  InvalidDataKeyType(4004),
  /**
   * The specified `op` was invalid or missing
   */
  UnknownOpCode(4005),
  /**
   * The client sent a websocket message without first sending `Identify` message
   */
  NotIdentified(4006),
  /**
   * The client sent an `Identify` message while already identified
   */
  AlreadyIdentified(4007),
  /**
   * The authentication attempt (via `Identify`), failed
   */
  AuthenticationFailed(4008),
  /**
   * The server detected the usage of an old version of the obs-websocket protocol.,
   */
  UnsupportedRpcVersion(4009),
  /**
   * The websocket session has been invalidated by the obs-websocket server.
   */
  SessionInvalidated(4010),
  ;

  private final int code;

  WebSocketCloseCode(int code) {
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