// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetInputVolumeResponse extends RequestResponse<GetInputVolumeResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Volume setting in mul
     */
    @NonNull
    private Number inputVolumeMul;

    /**
     * Volume setting in dB
     */
    @NonNull
    private Number inputVolumeDb;
  }
}
