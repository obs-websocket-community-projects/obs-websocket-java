package io.obswebsocket.community.client.message.request.mediainputs;

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
public class TriggerMediaInputActionRequest extends Request<TriggerMediaInputActionRequest.SpecificData> {
  @Builder
  private TriggerMediaInputActionRequest(String inputName, String mediaAction) {
    super(RequestType.TriggerMediaInputAction, SpecificData.builder().inputName(inputName).mediaAction(mediaAction).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String inputName;

    @NonNull
    private String mediaAction;
  }
}
