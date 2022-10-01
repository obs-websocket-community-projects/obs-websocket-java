package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputVolumeRequest extends InputRequest<InputRequest.Data> {

  @Builder
  private GetInputVolumeRequest(String inputName) {
    super(Request.Data.Type.GetInputVolume, Data.builder().inputName(inputName).build());
  }
}
