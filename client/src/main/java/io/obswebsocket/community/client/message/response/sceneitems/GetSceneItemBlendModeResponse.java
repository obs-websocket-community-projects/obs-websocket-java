package io.obswebsocket.community.client.message.response.sceneitems;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.message.response.sceneitems.GetSceneItemBlendModeResponse.Data;
import io.obswebsocket.community.client.model.SceneItemBlendMode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneItemBlendModeResponse extends RequestResponse<Data> {

  public GetSceneItemBlendModeResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {
    private SceneItemBlendMode sceneItemBlendMode;
  }

}
