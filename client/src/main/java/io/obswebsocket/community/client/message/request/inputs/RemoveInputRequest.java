package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RemoveInputRequest extends InputRequest {

  private final Data requestData;

  @Builder
  private RemoveInputRequest(String inputName) {
    super(Request.Data.Type.RemoveInput);

    this.requestData = Data.builder().inputName(inputName).build();
  }
}
