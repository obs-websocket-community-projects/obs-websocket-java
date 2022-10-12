package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetCurrentSceneCollectionRequest extends SceneCollectionRequest<SceneCollectionRequest.SpecificData> {
  @Builder
  private SetCurrentSceneCollectionRequest(String sceneCollectionName) {
    super(Request.Data.Type.SetCurrentSceneCollection, SpecificData.builder().sceneCollectionName(sceneCollectionName).build());
  }
}
