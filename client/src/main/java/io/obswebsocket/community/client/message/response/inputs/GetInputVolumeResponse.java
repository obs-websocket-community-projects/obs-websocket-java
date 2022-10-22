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
public class GetInputVolumeResponse extends RequestResponse<GetInputVolumeResponse.SpecificData> {
  /**
   * Volume setting in mul
   *
   * @return the inputVolumeMul
   */
  public Number getInputVolumeMul() {
    return getMessageData().getResponseData().getInputVolumeMul();
  }

  /**
   * Volume setting in dB
   *
   * @return the inputVolumeDb
   */
  public Number getInputVolumeDb() {
    return getMessageData().getResponseData().getInputVolumeDb();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Volume setting in mul
     */
    private Number inputVolumeMul;

    /**
     * Volume setting in dB
     */
    private Number inputVolumeDb;
  }
}
