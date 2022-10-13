package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetInputMuteResponse extends RequestResponse<Void> {
  public GetInputMuteResponse() {
    super();
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {

    private Boolean inputMuted;
  }
}
