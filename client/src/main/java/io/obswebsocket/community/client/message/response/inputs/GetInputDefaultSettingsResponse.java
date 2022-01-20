package io.obswebsocket.community.client.message.response.inputs;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputDefaultSettingsResponse extends RequestResponse {

  private Data responseData;

  public GetInputDefaultSettingsResponse() {
    super(Request.Data.Type.GetInputDefaultSettings);
  }

  @Getter
  @ToString
  public static class Data {

    private JsonObject defaultInputSettings;
  }
}
