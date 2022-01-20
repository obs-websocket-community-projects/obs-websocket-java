package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class DuplicateSceneItemRequest extends SceneItemRequest {

  private final Data requestData;

  @Builder
  private DuplicateSceneItemRequest(String sceneName, Integer sceneItemId,
      String destinationSceneName) {
    super(Request.Data.Type.DuplicateSceneItem);

    this.requestData = Data.builder().sceneName(sceneName).sceneItemId(sceneItemId)
        .destinationSceneName(destinationSceneName).build();
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends DataWithId {

    @NonNull
    private final String destinationSceneName;
  }
}
