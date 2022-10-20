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
public class SetInputNameRequest extends Request<SetInputNameRequest.SpecificData> {
  @Builder
  private SetInputNameRequest(String inputName, String newInputName) {
    super(RequestType.SetInputName, SpecificData.builder().inputName(inputName).newInputName(newInputName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String inputName;

    @NonNull
    private String newInputName;
  }
}
