package io.obswebsocket.community.client.message.authentication;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Reidentify extends Message {

  @SerializedName("d")
  private final Data messageData;

  @Builder
  private Reidentify(
      Boolean ignoreInvalidMessages,
      Integer eventSubscriptions
  ) {
    super(OperationCode.Reidentify);

    this.messageData = Data.builder()
        .ignoreInvalidMessages(ignoreInvalidMessages)
        .eventSubscriptions(eventSubscriptions)
        .build();
  }

  @AllArgsConstructor
  @ToString
  @Getter
  @Builder
  public static class Data {

    private final Boolean ignoreInvalidMessages;
    private final Integer eventSubscriptions;

  }
}
