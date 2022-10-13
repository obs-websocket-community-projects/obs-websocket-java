package io.obswebsocket.community.client.message.response.outputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetLastReplayBufferReplayResponse extends RequestResponse<GetLastReplayBufferReplayResponse.Data> {
  public GetLastReplayBufferReplayResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {
    private String savedReplayPath;
  }
}
