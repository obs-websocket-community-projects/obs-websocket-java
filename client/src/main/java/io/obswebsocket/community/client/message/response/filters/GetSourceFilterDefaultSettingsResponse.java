package io.obswebsocket.community.client.message.response.filters;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.message.response.filters.GetSourceFilterDefaultSettingsResponse.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSourceFilterDefaultSettingsResponse extends RequestResponse<Data> {
  public GetSourceFilterDefaultSettingsResponse() {
    super();
  }

  @Getter
  @ToString
  static class Data {
    private JsonObject defaultFilterSettings;
  }
}
