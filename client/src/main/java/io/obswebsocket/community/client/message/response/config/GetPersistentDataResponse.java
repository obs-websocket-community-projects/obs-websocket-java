package io.obswebsocket.community.client.message.response.config;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetPersistentDataResponse extends RequestResponse<GetPersistentDataResponse.Data> {
  public GetPersistentDataResponse() {
    super();
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private JsonObject data;  // TODO: type might change
  }
}
