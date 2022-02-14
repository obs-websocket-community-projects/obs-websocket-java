package io.obswebsocket.community.client.message.request.inputs;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class CreateInputRequest extends InputRequest {

  private final Data requestData;

  @Builder
  private CreateInputRequest(String inputName, String inputKind, String sceneName,
      JsonObject inputSettings, Boolean sceneItemEnabled) {
    super(Type.CreateInput);

    this.requestData = Data.builder().inputName(inputName).inputKind(inputKind).sceneName(sceneName)
        .inputSettings(inputSettings).sceneItemEnabled(sceneItemEnabled).build();
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends InputRequest.Data {

    @NonNull
    private final String inputKind;
    @NonNull
    private final String sceneName;
    private final JsonObject inputSettings; // optional
    private final Boolean sceneItemEnabled; // optional
  }
}
