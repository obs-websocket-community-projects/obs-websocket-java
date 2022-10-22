// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.general;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetStatsResponse extends RequestResponse<GetStatsResponse.SpecificData> {
  /**
   * Current CPU usage in percent
   *
   * @return the cpuUsage
   */
  public Number getCpuUsage() {
    return getMessageData().getResponseData().getCpuUsage();
  }

  /**
   * Amount of memory in MB currently being used by OBS
   *
   * @return the memoryUsage
   */
  public Number getMemoryUsage() {
    return getMessageData().getResponseData().getMemoryUsage();
  }

  /**
   * Available disk space on the device being used for recording storage
   *
   * @return the availableDiskSpace
   */
  public Number getAvailableDiskSpace() {
    return getMessageData().getResponseData().getAvailableDiskSpace();
  }

  /**
   * Current FPS being rendered
   *
   * @return the activeFps
   */
  public Number getActiveFps() {
    return getMessageData().getResponseData().getActiveFps();
  }

  /**
   * Average time in milliseconds that OBS is taking to render a frame
   *
   * @return the averageFrameRenderTime
   */
  public Number getAverageFrameRenderTime() {
    return getMessageData().getResponseData().getAverageFrameRenderTime();
  }

  /**
   * Number of frames skipped by OBS in the render thread
   *
   * @return the renderSkippedFrames
   */
  public Number getRenderSkippedFrames() {
    return getMessageData().getResponseData().getRenderSkippedFrames();
  }

  /**
   * Total number of frames outputted by the render thread
   *
   * @return the renderTotalFrames
   */
  public Number getRenderTotalFrames() {
    return getMessageData().getResponseData().getRenderTotalFrames();
  }

  /**
   * Number of frames skipped by OBS in the output thread
   *
   * @return the outputSkippedFrames
   */
  public Number getOutputSkippedFrames() {
    return getMessageData().getResponseData().getOutputSkippedFrames();
  }

  /**
   * Total number of frames outputted by the output thread
   *
   * @return the outputTotalFrames
   */
  public Number getOutputTotalFrames() {
    return getMessageData().getResponseData().getOutputTotalFrames();
  }

  /**
   * Total number of messages received by obs-websocket from the client
   *
   * @return the webSocketSessionIncomingMessages
   */
  public Number getWebSocketSessionIncomingMessages() {
    return getMessageData().getResponseData().getWebSocketSessionIncomingMessages();
  }

  /**
   * Total number of messages sent by obs-websocket to the client
   *
   * @return the webSocketSessionOutgoingMessages
   */
  public Number getWebSocketSessionOutgoingMessages() {
    return getMessageData().getResponseData().getWebSocketSessionOutgoingMessages();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Current CPU usage in percent
     */
    private Number cpuUsage;

    /**
     * Amount of memory in MB currently being used by OBS
     */
    private Number memoryUsage;

    /**
     * Available disk space on the device being used for recording storage
     */
    private Number availableDiskSpace;

    /**
     * Current FPS being rendered
     */
    private Number activeFps;

    /**
     * Average time in milliseconds that OBS is taking to render a frame
     */
    private Number averageFrameRenderTime;

    /**
     * Number of frames skipped by OBS in the render thread
     */
    private Number renderSkippedFrames;

    /**
     * Total number of frames outputted by the render thread
     */
    private Number renderTotalFrames;

    /**
     * Number of frames skipped by OBS in the output thread
     */
    private Number outputSkippedFrames;

    /**
     * Total number of frames outputted by the output thread
     */
    private Number outputTotalFrames;

    /**
     * Total number of messages received by obs-websocket from the client
     */
    private Number webSocketSessionIncomingMessages;

    /**
     * Total number of messages sent by obs-websocket to the client
     */
    private Number webSocketSessionOutgoingMessages;
  }
}
