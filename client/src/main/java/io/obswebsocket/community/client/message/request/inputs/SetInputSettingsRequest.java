package io.obswebsocket.community.client.message.request.inputs;

import com.google.gson.JsonObject;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetInputSettingsRequest extends InputRequest<SetInputSettingsRequest.Data> {
  @Builder
  private SetInputSettingsRequest(String inputName, JsonObject inputSettings, Boolean overlay) {
    super(Request.Data.Type.SetInputSettings, Data.builder().inputName(inputName).inputSettings(inputSettings)
                                                  .overlay(overlay).build());
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends InputRequest.Data {

    @NonNull
    private final JsonObject inputSettings;
    private final Boolean overlay;
  }
}
