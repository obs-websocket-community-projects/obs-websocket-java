package io.obswebsocket.community.client.message.request.sceneitems;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class CreateSceneItemRequest extends SceneItemRequest {

  private final Data requestData;

  @Builder
  private CreateSceneItemRequest(String sceneName, String sourceName, Boolean sceneItemEnabled) {
    super(Type.CreateSceneItem);

    this.requestData = Data.builder().sceneName(sceneName).sourceName(sourceName)
        .sceneItemEnabled(sceneItemEnabled).build();
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends SceneItemRequest.Data {

    @NonNull
    private final String sourceName;
    @NonNull
    private final Boolean sceneItemEnabled;
  }
}
