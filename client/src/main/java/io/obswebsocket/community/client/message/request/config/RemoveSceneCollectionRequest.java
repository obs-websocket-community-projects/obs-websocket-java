package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RemoveSceneCollectionRequest extends SceneCollectionRequest<SceneCollectionRequest.SpecificData> {
  @Builder
  private RemoveSceneCollectionRequest(String sceneCollectionName) {
    super(Request.Data.Type.RemoveSceneCollection, SpecificData.builder().sceneCollectionName(sceneCollectionName).build());
  }
}
