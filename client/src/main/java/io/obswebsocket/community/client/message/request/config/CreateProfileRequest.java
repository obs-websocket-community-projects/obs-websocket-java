package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CreateProfileRequest extends ProfileRequest {
  @Builder
  private CreateProfileRequest(String profileName) {
    super(RequestType.CreateProfile, Data.builder().profileName(profileName).build());
  }
}
