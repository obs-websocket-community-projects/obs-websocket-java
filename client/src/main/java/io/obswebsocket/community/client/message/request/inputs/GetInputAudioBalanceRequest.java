package io.obswebsocket.community.client.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputAudioBalanceRequest extends InputRequest<InputRequest.Data> {

  @Builder
  private GetInputAudioBalanceRequest(String inputName) {
    super(null, Data.builder().inputName(inputName).build());
  }
}
