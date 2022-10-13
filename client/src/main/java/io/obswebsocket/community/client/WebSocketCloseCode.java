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
  MissingDataField(4003),
  /**
   * A data key has an invalid type
   */
  InvalidDataFieldType(4004),
  /**
   * The specified `op` was invalid or missing
   */
  InvalidDataFieldValue(4005),
  /**
   * The client sent a websocket message without first sending `Identify` message
   */
  UnknownOpCode(4006),
  /**
   * The client sent a websocket message without first sending Identify message.
   */
  NotIdentified(4007),
  /**
   * The client sent an `Identify` message while already identified
   */
  AlreadyIdentified(4008),
  /**
   * The authentication attempt (via `Identify`), failed
   */
  AuthenticationFailed(4009),
  /**
   * The server detected the usage of an old version of the obs-websocket protocol.,
   */
  UnsupportedRpcVersion(4010),
  /**
   * The websocket session has been invalidated by the obs-websocket server.
   */
  SessionInvalidated(4011),
  /**
   * A requested feature is not supported due to hardware/software limitations.
   */
  UnsupportedFeature(4012),
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
