package io.obswebsocket.community.client.message.response.general;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSystemStatsResponse extends RequestResponse {

  private Data responseData;

  private GetSystemStatsResponse() {
    super(Request.Type.GetSystemStats);
  }

  @Getter
  @ToString
  public static class Data {
    // TODO: GetSystemStatsResponse data
  }
}
