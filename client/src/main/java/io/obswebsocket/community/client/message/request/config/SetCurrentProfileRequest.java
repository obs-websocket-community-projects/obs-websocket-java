package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetCurrentProfileRequest extends ProfileRequest {

  private final Data requestData;

  @Builder
  private SetCurrentProfileRequest(String profileName) {
    super(Request.Data.Type.SetCurrentProfile);

    this.requestData = Data.builder().profileName(profileName).build();
  }
}
