package io.obswebsocket.community.client.message.request.outputs;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class SetOutputSettingsRequest extends Request<SetOutputSettingsRequest.SpecificData> {

  @Builder
  private SetOutputSettingsRequest(String outputName, JsonObject outputSettings) {
    super(RequestType.SetOutputSettings,
        SpecificData.builder().outputName(outputName).outputSettings(outputSettings).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {

    @NonNull
    private String outputName;

    @NonNull
    private JsonObject outputSettings;
  }
}
