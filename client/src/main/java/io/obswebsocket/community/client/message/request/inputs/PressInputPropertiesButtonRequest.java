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
public class PressInputPropertiesButtonRequest extends Request<PressInputPropertiesButtonRequest.SpecificData> {
  @Builder
  private PressInputPropertiesButtonRequest(String inputName, String propertyName) {
    super(RequestType.PressInputPropertiesButton, SpecificData.builder().inputName(inputName).propertyName(propertyName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String inputName;

    @NonNull
    private String propertyName;
  }
}
