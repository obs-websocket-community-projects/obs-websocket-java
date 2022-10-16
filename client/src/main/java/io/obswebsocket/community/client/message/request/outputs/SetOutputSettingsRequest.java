package io.obswebsocket.community.client.message.request.outputs;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetOutputSettingsRequest extends OutputRequest<SetOutputSettingsRequest.Data> {

  @Builder
  private SetOutputSettingsRequest(String outputName, JsonObject outputSettings) {
    super(Request.Data.Type.SetOutputSettings,
        Data.builder().outputName(outputName).outputSettings(outputSettings).build());
  }

  @Getter
  @ToString
  @SuperBuilder
  static class Data extends OutputRequest.Data {

    private final JsonObject outputSettings; // TODO: Type
  }
}
