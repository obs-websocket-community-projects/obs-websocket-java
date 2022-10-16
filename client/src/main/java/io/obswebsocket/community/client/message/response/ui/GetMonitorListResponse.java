package io.obswebsocket.community.client.message.response.ui;

import com.google.gson.JsonArray;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.message.response.ui.GetMonitorListResponse.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetMonitorListResponse extends RequestResponse<Data> {

  @Getter
  @ToString
  public static class Data {

    private JsonArray monitors; // TODO: Type
  }
}
