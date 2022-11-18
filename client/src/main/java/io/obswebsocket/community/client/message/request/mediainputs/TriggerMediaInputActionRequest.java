// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.mediainputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import io.obswebsocket.community.client.model.MediaInputAction;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class TriggerMediaInputActionRequest extends Request<TriggerMediaInputActionRequest.SpecificData> {
  @Builder
  private TriggerMediaInputActionRequest(String inputName, MediaInputAction mediaAction) {
    super(RequestType.TriggerMediaInputAction, SpecificData.builder().inputName(inputName).mediaAction(mediaAction).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String inputName;

    @NonNull
    private MediaInputAction mediaAction;
  }
}
