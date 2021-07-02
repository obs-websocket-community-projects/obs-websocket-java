package io.obswebsocket.community.client.message.response.general;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetStudioModeEnabledResponse extends RequestResponse {

  private Data responseData;

  public GetStudioModeEnabledResponse() {
    super(Request.Type.GetStudioModeEnabled);
  }

  @Getter
  @ToString
  public static class Data {

    private Boolean studioModeEnabled;
  }
}
