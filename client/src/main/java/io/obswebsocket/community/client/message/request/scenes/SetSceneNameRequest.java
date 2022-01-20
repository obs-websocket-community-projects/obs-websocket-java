package io.obswebsocket.community.client.message.request.scenes;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetSceneNameRequest extends Request {

  private final Data requestData;

  @Builder
  private SetSceneNameRequest(String sceneName, String newSceneName) {
    super(Request.Data.Type.SetSceneName);

    this.requestData = Data.builder().sceneName(sceneName).newSceneName(newSceneName).build();
  }

  @Getter
  @ToString
  @SuperBuilder
  static class Data extends SceneRequest.Data {

    @NonNull
    private final String newSceneName;
  }
}
