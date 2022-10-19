package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputAudioBalanceResponse extends RequestResponse<GetInputAudioBalanceResponse.Data> {
  public GetInputAudioBalanceResponse() {
    super();
  }

  @Getter
  @ToString
  @Builder
  public static class Data {
    private Float inputAudioBalance;
  }
}
