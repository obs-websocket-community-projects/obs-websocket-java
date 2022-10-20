// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class SetInputAudioBalanceRequest extends Request<SetInputAudioBalanceRequest.SpecificData> {
  @Builder
  private SetInputAudioBalanceRequest(String inputName, Number inputAudioBalance) {
    super(RequestType.SetInputAudioBalance, SpecificData.builder().inputName(inputName).inputAudioBalance(inputAudioBalance).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String inputName;

    @NonNull
    private Number inputAudioBalance;
  }
}
