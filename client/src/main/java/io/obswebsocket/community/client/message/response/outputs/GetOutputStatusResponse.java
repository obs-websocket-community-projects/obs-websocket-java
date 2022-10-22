// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.outputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetOutputStatusResponse extends RequestResponse<GetOutputStatusResponse.SpecificData> {
  /**
   * Whether the output is active
   *
   * @return the outputActive
   */
  public Boolean getOutputActive() {
    return getMessageData().getResponseData().getOutputActive();
  }

  /**
   * Whether the output is reconnecting
   *
   * @return the outputReconnecting
   */
  public Boolean getOutputReconnecting() {
    return getMessageData().getResponseData().getOutputReconnecting();
  }

  /**
   * Current formatted timecode string for the output
   *
   * @return the outputTimecode
   */
  public String getOutputTimecode() {
    return getMessageData().getResponseData().getOutputTimecode();
  }

  /**
   * Current duration in milliseconds for the output
   *
   * @return the outputDuration
   */
  public Number getOutputDuration() {
    return getMessageData().getResponseData().getOutputDuration();
  }

  /**
   * Congestion of the output
   *
   * @return the outputCongestion
   */
  public Number getOutputCongestion() {
    return getMessageData().getResponseData().getOutputCongestion();
  }

  /**
   * Number of bytes sent by the output
   *
   * @return the outputBytes
   */
  public Number getOutputBytes() {
    return getMessageData().getResponseData().getOutputBytes();
  }

  /**
   * Number of frames skipped by the output's process
   *
   * @return the outputSkippedFrames
   */
  public Number getOutputSkippedFrames() {
    return getMessageData().getResponseData().getOutputSkippedFrames();
  }

  /**
   * Total number of frames delivered by the output's process
   *
   * @return the outputTotalFrames
   */
  public Number getOutputTotalFrames() {
    return getMessageData().getResponseData().getOutputTotalFrames();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Whether the output is active
     */
    private Boolean outputActive;

    /**
     * Whether the output is reconnecting
     */
    private Boolean outputReconnecting;

    /**
     * Current formatted timecode string for the output
     */
    private String outputTimecode;

    /**
     * Current duration in milliseconds for the output
     */
    private Number outputDuration;

    /**
     * Congestion of the output
     */
    private Number outputCongestion;

    /**
     * Number of bytes sent by the output
     */
    private Number outputBytes;

    /**
     * Number of frames skipped by the output's process
     */
    private Number outputSkippedFrames;

    /**
     * Total number of frames delivered by the output's process
     */
    private Number outputTotalFrames;
  }
}
