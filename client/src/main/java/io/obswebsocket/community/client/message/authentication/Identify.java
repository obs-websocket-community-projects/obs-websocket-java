package io.obswebsocket.community.client.message.authentication;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Identify extends Message {

  @SerializedName("d")
  private final Data messageData;

  @Builder
  private Identify(
      Integer rpcVersion,
      String authentication,
      Boolean ignoreInvalidMessages,
      Integer eventSubscriptions
  ) {
    super(OperationCode.Identify);

    this.messageData = Data.builder()
        .rpcVersion(rpcVersion)
        .authentication(authentication)
        .ignoreInvalidMessages(ignoreInvalidMessages)
        .eventSubscriptions(eventSubscriptions)
        .build();
  }

  @AllArgsConstructor
  @ToString
  @Getter
  @Builder
  public static class Data {

    private final Integer rpcVersion;
    private final String authentication;
    private final Boolean ignoreInvalidMessages;
    private final Integer eventSubscriptions;

  }
}
