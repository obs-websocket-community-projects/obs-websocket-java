package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetSceneItemLockedRequest extends SceneItemRequest<SetSceneItemLockedRequest.Data> {
  @Builder
  private SetSceneItemLockedRequest(String sceneName, Integer sceneItemId,
          Boolean sceneItemLocked) {
    super(Request.Data.Type.SetSceneItemLocked, Data.builder().sceneName(sceneName).sceneItemId(sceneItemId)
                                                    .sceneItemLocked(sceneItemLocked).build());
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends SceneItemRequest.DataWithId {

    @NonNull
    private final Boolean sceneItemLocked;
  }
}
