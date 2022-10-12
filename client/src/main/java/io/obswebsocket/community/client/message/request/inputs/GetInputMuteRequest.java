package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputMuteRequest extends InputRequest<InputRequest.Data> {
  @Builder
  private GetInputMuteRequest(String inputName) {
    super(Request.Data.Type.GetInputMute, Data.builder().inputName(inputName).build());
  }
}
