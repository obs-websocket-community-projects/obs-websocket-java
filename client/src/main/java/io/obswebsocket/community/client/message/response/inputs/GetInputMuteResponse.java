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
public class GetInputMuteResponse extends RequestResponse<GetInputMuteResponse.SpecificData> {
  /**
   * Whether the input is muted
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
     * Whether the input is muted
     */
    private Boolean inputMuted;
  }
}
