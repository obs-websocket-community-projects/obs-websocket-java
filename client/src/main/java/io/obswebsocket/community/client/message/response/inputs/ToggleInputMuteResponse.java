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
public class ToggleInputMuteResponse extends RequestResponse<ToggleInputMuteResponse.SpecificData> {
  /**
   * Whether the input has been muted or unmuted
   *
   * @return the inputMuted
   */
  public Boolean getInputMuted() {
    return getMessageData().getResponseData().getInputMuted();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Whether the input has been muted or unmuted
     */
    private Boolean inputMuted;
  }
}
