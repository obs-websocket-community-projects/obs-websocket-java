package io.obswebsocket.community.client.message.response.outputs;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.message.response.outputs.GetOutputSettingsResponse.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetOutputSettingsResponse extends RequestResponse<Data> {

  public GetOutputSettingsResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {

    private JsonObject outputSettings;
  }
}
