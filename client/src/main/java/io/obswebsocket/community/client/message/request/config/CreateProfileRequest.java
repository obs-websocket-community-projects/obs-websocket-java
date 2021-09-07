package io.obswebsocket.community.client.message.request.config;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CreateProfileRequest extends ProfileRequest {

  private final Data requestData;

  @Builder
  private CreateProfileRequest(String profileName) {
    super(Type.CreateProfile);

    this.requestData = Data.builder().profileName(profileName).build();
  }
}
