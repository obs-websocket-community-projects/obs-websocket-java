package io.obswebsocket.community.client.message.response.config;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetGlobalPersistentDataResponse extends RequestResponse {

  private Data responseData;

  public GetGlobalPersistentDataResponse() {
    super(Request.Type.GetGlobalPersistentData);
  }

  @Getter
  @ToString
  public static class Data {

    private JsonObject data;  // TODO: type might change
  }
}
