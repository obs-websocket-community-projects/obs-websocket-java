package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetInputAudioBalanceRequest extends
    InputRequest<SetInputAudioBalanceRequest.SpecificData> {

  @Builder
  private SetInputAudioBalanceRequest(String inputName, float inputAudioBalance) {
    super(Request.Data.Type.SetInputAudioBalance, SpecificData.builder()
        .inputName(inputName)
        .inputAudioBalance(inputAudioBalance)
        .build());
  }

  @SuperBuilder
  public static class SpecificData extends InputRequest.Data {

    private float inputAudioBalance;
  }
}
