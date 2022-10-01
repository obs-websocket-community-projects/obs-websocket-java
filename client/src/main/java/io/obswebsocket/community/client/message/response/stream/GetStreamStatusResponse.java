package io.obswebsocket.community.client.message.response.stream;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetStreamStatusResponse extends RequestResponse<GetStreamStatusResponse.Data> {
  public GetStreamStatusResponse() {
    super(Request.Data.Type.GetStreamStatus);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private Boolean outputActive;
    private Boolean outputReconnecting;
    private String outputTimecode;
    private Integer outputDuration;
    private Integer outputBytes;
    private Integer outputSkippedFrames;
    private Integer outputTotalFrames;
  }
}
