package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputVolumeRequest extends InputRequest {

  private final Data requestData;

  @Builder
  private GetInputVolumeRequest(String inputName) {
    super(Request.Data.Type.GetInputVolume);

    this.requestData = Data.builder().inputName(inputName).build();
  }
}
