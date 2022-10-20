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
public class CreateInputRequest extends Request<CreateInputRequest.SpecificData> {
  @Builder
  private CreateInputRequest(String sceneName, String inputName, String inputKind,
      JsonObject inputSettings, Boolean sceneItemEnabled) {
    super(RequestType.CreateInput, SpecificData.builder().sceneName(sceneName).inputName(inputName).inputKind(inputKind).inputSettings(inputSettings).sceneItemEnabled(sceneItemEnabled).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String sceneName;

    @NonNull
    private String inputName;

    @NonNull
    private String inputKind;

    private JsonObject inputSettings;

    private Boolean sceneItemEnabled;
  }
}
