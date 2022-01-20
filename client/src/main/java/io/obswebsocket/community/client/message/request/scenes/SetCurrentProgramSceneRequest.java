package io.obswebsocket.community.client.message.request.scenes;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetCurrentProgramSceneRequest extends SceneRequest {

  private final Data requestData;

  @Builder
  private SetCurrentProgramSceneRequest(String sceneName) {
    super(Request.Data.Type.SetCurrentProgramScene);

    this.requestData = Data.builder().sceneName(sceneName).build();
  }
}
