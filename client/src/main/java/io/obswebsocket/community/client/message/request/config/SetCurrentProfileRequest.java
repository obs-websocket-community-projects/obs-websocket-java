package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetCurrentProfileRequest extends ProfileRequest {
  @Builder
  private SetCurrentProfileRequest(String profileName) {
    super(Request.Data.Type.SetCurrentProfile, Data.builder().profileName(profileName).build());
  }
}
