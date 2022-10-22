// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetInputAudioSyncOffsetResponse extends RequestResponse<GetInputAudioSyncOffsetResponse.SpecificData> {
  /**
   * Audio sync offset in milliseconds
   *
   * @return the inputAudioSyncOffset
   */
  public Number getInputAudioSyncOffset() {
    return getMessageData().getResponseData().getInputAudioSyncOffset();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Audio sync offset in milliseconds
     */
    private Number inputAudioSyncOffset;
  }
}
