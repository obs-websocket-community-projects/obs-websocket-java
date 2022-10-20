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
public class GetInputVolumeRequest extends Request<GetInputVolumeRequest.SpecificData> {
  @Builder
  private GetInputVolumeRequest(String inputName) {
    super(RequestType.GetInputVolume, SpecificData.builder().inputName(inputName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String inputName;
  }
}
