package io.obswebsocket.community.client.message.request.mediainputs;

import io.obswebsocket.community.client.message.request.RequestType;
import io.obswebsocket.community.client.message.request.mediainputs.TriggerMediaInputActionRequest.Data;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class TriggerMediaInputActionRequest extends MediaInputRequest<Data> {

  @Builder
  private TriggerMediaInputActionRequest(String inputName, String mediaAction) {
    super(RequestType.TriggerMediaInputAction,
        Data.builder().inputName(inputName).mediaAction(mediaAction).build());
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends MediaInputRequest.Data {

    private String mediaAction;
  }
}
