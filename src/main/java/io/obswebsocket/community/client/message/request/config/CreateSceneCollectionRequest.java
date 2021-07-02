package io.obswebsocket.community.client.message.request.config;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CreateSceneCollectionRequest extends SceneCollectionRequest {

  public final Data requestData;

  @Builder
  private CreateSceneCollectionRequest(String sceneCollectionName) {
    super(Type.SetCurrentSceneCollection);

    this.requestData = Data.builder().sceneCollectionName(sceneCollectionName).build();
  }
}
