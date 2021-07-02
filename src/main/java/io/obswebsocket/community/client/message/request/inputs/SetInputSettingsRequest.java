package io.obswebsocket.community.client.message.request.inputs;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetInputSettingsRequest extends InputRequest {

  private final Data requestData;

  @Builder
  private SetInputSettingsRequest(String inputName, JsonObject inputSettings, Boolean overlay) {
    super(Type.SetInputSettings);

    this.requestData = Data.builder().inputName(inputName).inputSettings(inputSettings)
        .overlay(overlay).build();
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
