package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CreateSceneCollectionRequest extends SceneCollectionRequest {

  public final Data requestData;

  @Builder
  private CreateSceneCollectionRequest(String sceneCollectionName) {
    super(Request.Data.Type.SetCurrentSceneCollection);

    this.requestData = Data.builder().sceneCollectionName(sceneCollectionName).build();
  }
}
