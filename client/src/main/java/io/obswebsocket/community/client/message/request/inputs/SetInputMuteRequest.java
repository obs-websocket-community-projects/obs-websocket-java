package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetInputMuteRequest extends InputRequest {

  private final Data requestData;

  @Builder
  private SetInputMuteRequest(String inputName, Boolean inputMuted) {
    super(Request.Data.Type.SetInputMute);

    this.requestData = Data.builder().inputName(inputName).inputMuted(inputMuted).build();
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends InputRequest.Data {

    @NonNull
    private final Boolean inputMuted;
  }
}
