package io.obswebsocket.community.client.message.request.general;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetStudioModeEnabledRequest extends Request {

  private final Data requestData;

  @Builder
  private SetStudioModeEnabledRequest(Boolean studioModeEnabled) {
    super(Type.SetStudioModeEnabled);

    this.requestData = Data.builder().studioModeEnabled(studioModeEnabled).build();
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    @NonNull
    private final Boolean studioModeEnabled;
  }
}
