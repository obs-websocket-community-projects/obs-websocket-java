package io.obswebsocket.community.client.message.response.general;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class GetStatsResponse extends RequestResponse<GetStatsResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Current CPU usage in percent
     */
    @NonNull
    private Number cpuUsage;

    /**
     * Amount of memory in MB currently being used by OBS
     */
    @NonNull
    private Number memoryUsage;

    /**
     * Available disk space on the device being used for recording storage
     */
    @NonNull
    private Number availableDiskSpace;

    /**
     * Current FPS being rendered
     */
    @NonNull
    private Number activeFps;

    /**
     * Average time in milliseconds that OBS is taking to render a frame
     */
    @NonNull
    private Number averageFrameRenderTime;

    /**
     * Number of frames skipped by OBS in the render thread
     */
    @NonNull
    private Number renderSkippedFrames;

    /**
     * Total number of frames outputted by the render thread
     */
    @NonNull
    private Number renderTotalFrames;

    /**
     * Number of frames skipped by OBS in the output thread
     */
    @NonNull
    private Number outputSkippedFrames;

    /**
     * Total number of frames outputted by the output thread
     */
    @NonNull
    private Number outputTotalFrames;

    /**
     * Total number of messages received by obs-websocket from the client
     */
    @NonNull
    private Number webSocketSessionIncomingMessages;

    /**
     * Total number of messages sent by obs-websocket to the client
     */
    @NonNull
    private Number webSocketSessionOutgoingMessages;
  }
}
