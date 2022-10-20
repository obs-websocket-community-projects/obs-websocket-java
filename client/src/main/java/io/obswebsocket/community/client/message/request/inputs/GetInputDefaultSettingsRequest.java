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
public class GetInputDefaultSettingsRequest extends Request<GetInputDefaultSettingsRequest.SpecificData> {
  @Builder
  private GetInputDefaultSettingsRequest(String inputKind) {
    super(RequestType.GetInputDefaultSettings, SpecificData.builder().inputKind(inputKind).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String inputKind;
  }
}
