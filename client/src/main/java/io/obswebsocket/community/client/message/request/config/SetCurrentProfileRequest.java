// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.config;

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
public class SetCurrentProfileRequest extends Request<SetCurrentProfileRequest.SpecificData> {
  @Builder
  private SetCurrentProfileRequest(String profileName) {
    super(RequestType.SetCurrentProfile, SpecificData.builder().profileName(profileName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String profileName;
  }
}
