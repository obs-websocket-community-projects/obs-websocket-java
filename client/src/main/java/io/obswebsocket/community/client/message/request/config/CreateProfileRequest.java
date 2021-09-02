package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CreateProfileRequest extends Request {

  private final Data requestData;

  @Builder
  private CreateProfileRequest(String profileName) {
    super(Type.CreateProfile);

    this.requestData = Data.builder().profileName(profileName).build();
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    @NonNull
    private final String profileName;
  }
}
