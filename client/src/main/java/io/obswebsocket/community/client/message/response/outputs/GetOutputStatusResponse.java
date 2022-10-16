package io.obswebsocket.community.client.message.response.outputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetOutputStatusResponse extends RequestResponse<GetOutputStatusResponse.Data> {

  public GetOutputStatusResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {

    private Boolean outputActive;
    private Boolean outputReconnecting;
    private String outputTimecode;
    private Long outputDuration;
    private Long outputCongestion;
    private Long outputBytes;
    private Long outputSkippedFrames;
    private Long outputTotalFrames;
  }
}
