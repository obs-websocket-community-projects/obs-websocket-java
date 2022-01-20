package io.obswebsocket.community.client.message.request.scenes;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CreateSceneRequest extends SceneRequest {

  private final Data requestData;

  @Builder
  private CreateSceneRequest(String sceneName) {
    super(Request.Data.Type.CreateScene);

    this.requestData = Data.builder().sceneName(sceneName).build();
  }
}
