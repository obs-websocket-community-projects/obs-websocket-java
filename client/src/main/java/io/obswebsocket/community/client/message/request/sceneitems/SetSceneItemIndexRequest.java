package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetSceneItemIndexRequest extends SceneItemRequest<SetSceneItemIndexRequest.Data> {
  @Builder
  private SetSceneItemIndexRequest(String sceneName, Integer sceneItemId, Integer sceneItemIndex) {
    super(Request.Data.Type.SetSceneItemIndex, Data.builder().sceneName(sceneName).sceneItemId(sceneItemId)
                                                   .sceneItemIndex(sceneItemIndex).build());
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends SceneItemRequest.DataWithId {

    @NonNull
    private final Integer sceneItemIndex;
  }
}
