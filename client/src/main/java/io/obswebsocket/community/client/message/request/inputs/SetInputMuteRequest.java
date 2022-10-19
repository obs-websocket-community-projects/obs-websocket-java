package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class SetInputMuteRequest extends Request<SetInputMuteRequest.SpecificData> {
  @Builder
  private SetInputMuteRequest(String inputName, Boolean inputMuted) {
    super(RequestType.SetInputMute, SpecificData.builder().inputName(inputName).inputMuted(inputMuted).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String inputName;

    @NonNull
    private Boolean inputMuted;
  }
}
