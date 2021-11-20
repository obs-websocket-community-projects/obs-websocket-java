package io.obswebsocket.community.client.message.authentication;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Hello extends Message {

  @SerializedName("d")
  private final Data messageData;

  @Builder
  private Hello(
      String obsWebSocketVersion,
      Data.Authentication authentication,
      int rpcVersion
  ) {
    super(OperationCode.Hello);

    this.messageData = Data.builder()
        .obsWebSocketVersion(obsWebSocketVersion)
        .authentication(authentication)
        .rpcVersion(rpcVersion)
        .build();
  }

  public boolean isAuthenticationRequired() {
    return this.messageData != null && this.messageData.authentication != null;
  }

  @AllArgsConstructor
  @ToString
  @Getter
  @Builder
  public static class Data {

    private final String obsWebSocketVersion;
    private final Authentication authentication;
    private final int rpcVersion;

    @AllArgsConstructor
    @ToString
    @Getter
    @Builder
    public static class Authentication {

      private final String challenge;
      private final String salt;
    }
  }
}
