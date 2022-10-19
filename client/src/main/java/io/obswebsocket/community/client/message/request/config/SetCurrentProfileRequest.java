package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetCurrentProfileRequest extends ProfileRequest {
  @Builder
  private SetCurrentProfileRequest(String profileName) {
    super(RequestType.SetCurrentProfile, Data.builder().profileName(profileName).build());
  }
}
