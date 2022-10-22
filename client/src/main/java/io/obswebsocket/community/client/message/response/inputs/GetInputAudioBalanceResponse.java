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
public class GetInputAudioBalanceResponse extends RequestResponse<GetInputAudioBalanceResponse.SpecificData> {
  /**
   * Audio balance value from 0.0-1.0
   *
   * @return the inputAudioBalance
   */
  public Number getInputAudioBalance() {
    return getMessageData().getResponseData().getInputAudioBalance();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Audio balance value from 0.0-1.0
     */
    private Number inputAudioBalance;
  }
}
