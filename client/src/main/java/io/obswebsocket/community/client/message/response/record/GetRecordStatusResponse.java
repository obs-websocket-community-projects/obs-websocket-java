// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.record;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetRecordStatusResponse extends RequestResponse<GetRecordStatusResponse.SpecificData> {
  /**
   * Whether the output is active
   *
   * @return the outputActive
   */
  public Boolean getOutputActive() {
    return getMessageData().getResponseData().getOutputActive();
  }

  /**
   * Whether the output is paused
   *
   * @return the outputPaused
   */
  public Boolean getOutputPaused() {
    return getMessageData().getResponseData().getOutputPaused();
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
   * Number of bytes sent by the output
   *
   * @return the outputBytes
   */
  public Number getOutputBytes() {
    return getMessageData().getResponseData().getOutputBytes();
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
     * Whether the output is paused
     */
    private Boolean outputPaused;

    /**
     * Current formatted timecode string for the output
     */
    private String outputTimecode;

    /**
     * Current duration in milliseconds for the output
     */
    private Number outputDuration;

    /**
     * Number of bytes sent by the output
     */
    private Number outputBytes;
  }
}
