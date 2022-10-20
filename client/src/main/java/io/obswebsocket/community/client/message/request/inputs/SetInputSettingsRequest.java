// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.inputs;

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
public class SetInputSettingsRequest extends Request<SetInputSettingsRequest.SpecificData> {
  @Builder
  private SetInputSettingsRequest(String inputName, JsonObject inputSettings, Boolean overlay) {
    super(RequestType.SetInputSettings, SpecificData.builder().inputName(inputName).inputSettings(inputSettings).overlay(overlay).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String inputName;

    @NonNull
    private JsonObject inputSettings;

    private Boolean overlay;
  }
}
