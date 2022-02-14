package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RemoveProfileRequest extends ProfileRequest {

  private final Data requestData;

  @Builder
  private RemoveProfileRequest(String profileName) {
    super(Type.RemoveProfile);

    this.requestData = Data.builder().profileName(profileName).build();
  }
}
