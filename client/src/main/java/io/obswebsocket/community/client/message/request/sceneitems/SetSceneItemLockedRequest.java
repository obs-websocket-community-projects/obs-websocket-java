package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetSceneItemLockedRequest extends SceneItemRequest {

  private final Data requestData;

  @Builder
  private SetSceneItemLockedRequest(String sceneName, Integer sceneItemId,
      Boolean sceneItemLocked) {
    super(Request.Data.Type.SetSceneItemLocked);

    this.requestData = Data.builder().sceneName(sceneName).sceneItemId(sceneItemId)
        .sceneItemLocked(sceneItemLocked).build();
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends DataWithId {

    @NonNull
    private final Boolean sceneItemLocked;
  }
}
