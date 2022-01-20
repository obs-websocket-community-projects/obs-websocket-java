package io.obswebsocket.community.client.message.request.scenes;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RemoveSceneRequest extends SceneRequest {

  private final Data requestData;

  @Builder
  private RemoveSceneRequest(String sceneName) {
    super(Request.Data.Type.RemoveScene);

    this.requestData = Data.builder().sceneName(sceneName).build();
  }
}
