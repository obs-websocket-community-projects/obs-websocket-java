package io.obswebsocket.community.client.message.response.stream;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetStreamServiceSettingsResponse extends RequestResponse {

  private Data responseData;

  public GetStreamServiceSettingsResponse() {
    super(Request.Type.GetStreamServiceSettings);
  }

  @Getter
  @ToString
  public static class Data {

    // TODO: find exact type
    private String streamServiceType;
    private JsonObject serviceSettings;
  }
}
