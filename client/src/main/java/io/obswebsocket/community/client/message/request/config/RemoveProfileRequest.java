package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RemoveProfileRequest extends ProfileRequest {
  @Builder
  private RemoveProfileRequest(String profileName) {
    super(RequestType.RemoveProfile, Data.builder().profileName(profileName).build());
  }
}
