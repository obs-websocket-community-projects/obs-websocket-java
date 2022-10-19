package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CreateSceneCollectionRequest extends SceneCollectionRequest<SceneCollectionRequest.SpecificData> {
  @Builder
  private CreateSceneCollectionRequest(String sceneCollectionName) {
    super(RequestType.SetCurrentSceneCollection,
        SpecificData.builder().sceneCollectionName(sceneCollectionName).build());
  }
}
