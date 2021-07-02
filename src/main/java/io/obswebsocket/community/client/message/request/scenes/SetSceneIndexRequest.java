package io.obswebsocket.community.client.message.request.scenes;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetSceneIndexRequest extends Request {

  private final Data requestData;

  @Builder
  private SetSceneIndexRequest(String sceneName, Integer sceneIndex) {
    super(Type.SetSceneIndex);

    this.requestData = Data.builder().sceneName(sceneName).sceneIndex(sceneIndex).build();
  }

  @Getter
  @ToString
  @SuperBuilder
  static class Data extends SceneRequest.Data {

    @NonNull
    private final Integer sceneIndex;
  }
}
