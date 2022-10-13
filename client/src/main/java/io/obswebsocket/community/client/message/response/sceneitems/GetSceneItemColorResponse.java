package io.obswebsocket.community.client.message.response.sceneitems;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneItemColorResponse extends RequestResponse<GetSceneItemColorResponse.Data> {
  public GetSceneItemColorResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {
    private Integer sceneItemColor;
  }
}
