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
public class CreateProfileRequest extends Request<CreateProfileRequest.SpecificData> {
  @Builder
  private CreateProfileRequest(String profileName) {
    super(RequestType.CreateProfile, SpecificData.builder().profileName(profileName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String profileName;
  }
}
