package io.obswebsocket.community.client.message.response.inputs;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetInputDefaultSettingsResponse extends RequestResponse<GetInputDefaultSettingsResponse.Data> {
  public GetInputDefaultSettingsResponse() {
    super();
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private JsonObject defaultInputSettings;
  }
}
