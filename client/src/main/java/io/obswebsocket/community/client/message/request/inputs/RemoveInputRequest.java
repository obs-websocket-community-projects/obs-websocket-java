package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RemoveInputRequest extends InputRequest<InputRequest.Data> {
  @Builder
  private RemoveInputRequest(String inputName) {
    super(RequestType.RemoveInput, Data.builder().inputName(inputName).build());
  }
}
