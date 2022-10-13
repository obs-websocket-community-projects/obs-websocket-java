package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputAudioMonitorTypeRequest extends InputRequest<InputRequest.Data> {
  @Builder
  private GetInputAudioMonitorTypeRequest(String inputName) {
    super(Request.Data.Type.GetInputAudioMonitorType, Data.builder().inputName(inputName).build());
  }
}
