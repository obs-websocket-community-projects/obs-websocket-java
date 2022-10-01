package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CreateProfileRequest extends ProfileRequest {
  @Builder
  private CreateProfileRequest(String profileName) {
    super(Request.Data.Type.CreateProfile, Data.builder().profileName(profileName).build());
  }
}
