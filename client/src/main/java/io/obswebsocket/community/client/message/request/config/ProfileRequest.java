package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class ProfileRequest extends Request {

  ProfileRequest(Type type) {
    super(type);
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    @NonNull
    private final String profileName;
  }
}
