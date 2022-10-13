package io.obswebsocket.community.client.message.request.general;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetStudioModeEnabledRequest extends Request<SetStudioModeEnabledRequest.Data> {
  @Builder
  private SetStudioModeEnabledRequest(Boolean studioModeEnabled) {
    super(Request.Data.Type.SetStudioModeEnabled, Data.builder().studioModeEnabled(studioModeEnabled).build());
  }

  @Getter
  @ToString
  @Builder
  static class Data {
    @NonNull
    private final Boolean studioModeEnabled;
  }
}
