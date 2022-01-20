package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputAudioMonitorTypeRequest extends InputRequest {

  private final Data requestData;

  @Builder
  private GetInputAudioMonitorTypeRequest(String inputName) {
    super(Request.Data.Type.GetInputAudioMonitorType);

    this.requestData = Data.builder().inputName(inputName).build();
  }
}
