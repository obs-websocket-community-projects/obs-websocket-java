package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetCurrentSceneCollectionRequest extends SceneCollectionRequest<SceneCollectionRequest.SpecificData> {
  @Builder
  private SetCurrentSceneCollectionRequest(String sceneCollectionName) {
    super(RequestType.SetCurrentSceneCollection,
        SpecificData.builder().sceneCollectionName(sceneCollectionName).build());
  }
}
