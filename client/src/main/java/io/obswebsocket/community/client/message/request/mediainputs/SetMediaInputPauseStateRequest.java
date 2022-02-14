package io.obswebsocket.community.client.message.request.mediainputs;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetMediaInputPauseStateRequest extends MediaInputRequest {

  private final Data requestData;

  @Builder
  private SetMediaInputPauseStateRequest(String inputName, Boolean pause) {
    super(Type.SetMediaInputPauseState);

    this.requestData = Data.builder().inputName(inputName).pause(pause).build();
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends MediaInputRequest.Data {

    @NonNull
    private final Boolean pause;
  }
}