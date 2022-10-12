package io.obswebsocket.community.client.message.response.outputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetReplayBufferStatusResponse extends RequestResponse<GetReplayBufferStatusResponse.Data> {
  public GetReplayBufferStatusResponse() {
    super();
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private Boolean replayBufferActive;
  }
}
