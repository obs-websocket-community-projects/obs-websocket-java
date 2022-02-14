package io.obswebsocket.community.client.message.authentication;

import io.obswebsocket.community.client.message.Message;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Identify extends Message {

  private final Integer rpcVersion;
  private final String authentication;
  private final Boolean ignoreInvalidMessages;
  private final Boolean ignoreNonFatalRequestChecks;
  private final Integer eventSubscriptions;

  @Builder
  private Identify(
      Integer rpcVersion,
      String authentication,
      Boolean ignoreInvalidMessages,
      Boolean ignoreNonFatalRequestChecks,
      Integer eventSubscriptions
  ) {
    super(Type.Identify);

    this.rpcVersion = rpcVersion;
    this.authentication = authentication;
    this.ignoreInvalidMessages = ignoreInvalidMessages;
    this.ignoreNonFatalRequestChecks = ignoreNonFatalRequestChecks;
    this.eventSubscriptions = eventSubscriptions;
  }
}
