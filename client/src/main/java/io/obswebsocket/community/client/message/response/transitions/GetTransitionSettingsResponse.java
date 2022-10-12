package io.obswebsocket.community.client.message.response.transitions;

import com.google.gson.JsonObject;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetTransitionSettingsResponse extends RequestResponse<GetTransitionSettingsResponse.Data> {
  public GetTransitionSettingsResponse() {
    super(Request.Data.Type.GetTransitionSettings);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private JsonObject transitionSettings;
  }
}
