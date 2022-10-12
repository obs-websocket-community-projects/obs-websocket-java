package io.obswebsocket.community.client.message.response.general;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetStatsResponse extends RequestResponse<GetStatsResponse.Data> {
  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private Double cpuUsage;
    private Double memoryUsage;
    private Double availableDiskSpace;
    private Double activeFps;
    private Double averageFrameRenderTime;
    private Double renderSkippedFrames;
    private Double renderTotalFrames;
    private Double outputSkippedFrames;
    private Double outputTotalFrames;
  }
}
