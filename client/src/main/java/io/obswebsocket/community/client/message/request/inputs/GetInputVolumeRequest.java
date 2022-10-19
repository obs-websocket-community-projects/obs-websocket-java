package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputVolumeRequest extends InputRequest<InputRequest.Data> {

  @Builder
  private GetInputVolumeRequest(String inputName) {
    super(RequestType.GetInputVolume, Data.builder().inputName(inputName).build());
  }
}
