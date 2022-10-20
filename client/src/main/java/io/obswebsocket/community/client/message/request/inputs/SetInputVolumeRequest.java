// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class SetInputVolumeRequest extends Request<SetInputVolumeRequest.SpecificData> {
  @Builder
  private SetInputVolumeRequest(String inputName, Number inputVolumeMul, Number inputVolumeDb) {
    super(RequestType.SetInputVolume, SpecificData.builder().inputName(inputName).inputVolumeMul(inputVolumeMul).inputVolumeDb(inputVolumeDb).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String inputName;

    private Number inputVolumeMul;

    private Number inputVolumeDb;
  }
}
