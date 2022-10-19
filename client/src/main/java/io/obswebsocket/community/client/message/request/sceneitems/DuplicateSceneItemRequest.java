package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class DuplicateSceneItemRequest extends SceneItemRequest<DuplicateSceneItemRequest.Data> {
  @Builder
  private DuplicateSceneItemRequest(String sceneName, Integer sceneItemId,
          String destinationSceneName) {
    super(RequestType.DuplicateSceneItem,
        Data.builder().sceneName(sceneName).sceneItemId(sceneItemId)
            .destinationSceneName(destinationSceneName).build());
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends SceneItemRequest.DataWithId {

    private final String destinationSceneName;
  }
}
