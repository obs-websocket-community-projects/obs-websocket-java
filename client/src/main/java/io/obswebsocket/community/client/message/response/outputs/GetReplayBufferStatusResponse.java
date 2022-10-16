package io.obswebsocket.community.client.message.response.outputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetReplayBufferStatusResponse extends RequestResponse<GetReplayBufferStatusResponse.Data> {
  public GetReplayBufferStatusResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {
    private Boolean outputActive;
  }
}
