// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.transitions;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class SetCurrentSceneTransitionSettingsRequest extends Request<SetCurrentSceneTransitionSettingsRequest.SpecificData> {
  @Builder
  private SetCurrentSceneTransitionSettingsRequest(JsonObject transitionSettings, Boolean overlay) {
    super(RequestType.SetCurrentSceneTransitionSettings, SpecificData.builder().transitionSettings(transitionSettings).overlay(overlay).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private JsonObject transitionSettings;

    private Boolean overlay;
  }
}
