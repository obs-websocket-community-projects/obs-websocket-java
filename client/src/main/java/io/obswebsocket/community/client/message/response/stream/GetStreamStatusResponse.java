package io.obswebsocket.community.client.message.response.stream;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetStreamStatusResponse extends RequestResponse<GetStreamStatusResponse.Data> {

  public GetStreamStatusResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {

    private Boolean outputActive;
    private Boolean outputReconnecting;
    private String outputTimecode;
    private Integer outputDuration;
    private Integer outputCongestion;
    private Integer outputBytes;
    private Integer outputSkippedFrames;
    private Integer outputTotalFrames;
  }
}
