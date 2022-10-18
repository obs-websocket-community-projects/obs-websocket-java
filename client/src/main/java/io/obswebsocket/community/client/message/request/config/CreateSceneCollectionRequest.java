package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request.Data.Type;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CreateSceneCollectionRequest extends SceneCollectionRequest<SceneCollectionRequest.SpecificData> {
  @Builder
  private CreateSceneCollectionRequest(String sceneCollectionName) {
    super(
        Type.CreateSceneCollection, SpecificData.builder().sceneCollectionName(sceneCollectionName).build());
  }
}
