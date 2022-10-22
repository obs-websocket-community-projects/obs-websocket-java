package io.obswebsocket.community.client.message.authentication;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Identified extends Message {

  @SerializedName("d")
  private final Data messageData;

  @Builder
  private Identified(Integer negotiatedRpcVersion) {
    super(OperationCode.Identified);

    this.messageData = Data.builder().negotiatedRpcVersion(negotiatedRpcVersion).build();
  }

  @AllArgsConstructor
  @ToString
  @Getter
  @Builder
  public static class Data {

    private final Integer negotiatedRpcVersion;

  }
}
