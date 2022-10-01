package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
abstract class ProfileRequest extends Request<ProfileRequest.Data> {
  ProfileRequest(Request.Data.Type type, ProfileRequest.Data data) {
    super(type, data);
  }

  @Getter
  @ToString
  @Builder
  static class Data {
    @NonNull
    private final String profileName;
  }
}
