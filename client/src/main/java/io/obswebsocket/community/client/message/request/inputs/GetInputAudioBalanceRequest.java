package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputAudioBalanceRequest extends InputRequest<InputRequest.Data> {

  @Builder
  private GetInputAudioBalanceRequest(String inputName) {
    super(Request.Data.Type.GetInputAudioBalance, Data.builder().inputName(inputName).build());
  }
}
