package io.obswebsocket.community.client.message.response.sceneitems;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneItemEnabledResponse extends RequestResponse {

  private Data responseData;

  public GetSceneItemEnabledResponse() {
    super(Request.Type.GetSceneItemEnabled);
  }

  @Getter
  @ToString
  public static class Data {

    private Boolean sceneItemEnabled;
  }
}
