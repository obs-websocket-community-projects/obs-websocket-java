package io.obswebsocket.community.client.message.request.transitions;

import com.google.gson.JsonObject;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetTransitionSettingsRequest extends TransitionRequest<SetTransitionSettingsRequest.Data> {
  @Builder
  private SetTransitionSettingsRequest(String transitionName, JsonObject transitionSettings) {
    super(Request.Data.Type.SetTransitionSettings, Data.builder().transitionName(transitionName)
                                                       .transitionSettings(transitionSettings).build());
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends TransitionRequest.Data {

    @NonNull
    private final JsonObject transitionSettings;
  }
}
