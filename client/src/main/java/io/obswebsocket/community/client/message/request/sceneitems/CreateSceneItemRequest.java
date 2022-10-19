package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class CreateSceneItemRequest extends SceneItemRequest<CreateSceneItemRequest.Data> {
  @Builder
  private CreateSceneItemRequest(String sceneName, String sourceName, Boolean sceneItemEnabled) {
    super(RequestType.CreateSceneItem, Data.builder().sceneName(sceneName).sourceName(sourceName)
        .sceneItemEnabled(sceneItemEnabled).build());
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends SceneItemRequest.Data {

    @NonNull
    private final String sourceName;
    private final Boolean sceneItemEnabled;
  }
}
