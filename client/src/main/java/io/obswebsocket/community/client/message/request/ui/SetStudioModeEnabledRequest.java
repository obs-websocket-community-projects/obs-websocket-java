// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.ui;

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
public class SetStudioModeEnabledRequest extends Request<SetStudioModeEnabledRequest.SpecificData> {
  @Builder
  private SetStudioModeEnabledRequest(Boolean studioModeEnabled) {
    super(RequestType.SetStudioModeEnabled, SpecificData.builder().studioModeEnabled(studioModeEnabled).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private Boolean studioModeEnabled;
  }
}
