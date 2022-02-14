package io.obswebsocket.community.client.message.response.sceneitems;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneItemColorResponse extends RequestResponse {

  private Data responseData;

  public GetSceneItemColorResponse() {
    super(Request.Type.GetSceneItemColor);
  }

  @Getter
  @ToString
  public static class Data {

    private Integer sceneItemColor;
  }
}
