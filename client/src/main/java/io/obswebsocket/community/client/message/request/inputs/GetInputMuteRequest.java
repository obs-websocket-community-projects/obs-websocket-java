package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputMuteRequest extends InputRequest<InputRequest.Data> {
  @Builder
  private GetInputMuteRequest(String inputName) {
    super(RequestType.GetInputMute, Data.builder().inputName(inputName).build());
  }
}
