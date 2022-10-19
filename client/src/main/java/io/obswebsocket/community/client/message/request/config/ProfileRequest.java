package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
abstract class ProfileRequest extends Request<ProfileRequest.Data> {

  ProfileRequest(RequestType type, ProfileRequest.Data data) {
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
