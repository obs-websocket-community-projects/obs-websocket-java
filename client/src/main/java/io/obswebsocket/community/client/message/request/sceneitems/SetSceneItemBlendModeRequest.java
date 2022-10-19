package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.RequestType;
import io.obswebsocket.community.client.model.SceneItem;
import io.obswebsocket.community.client.model.SceneItem.BlendMode;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetSceneItemBlendModeRequest extends SceneItemRequest<SetSceneItemBlendModeRequest.Data> {

  @Builder
  private SetSceneItemBlendModeRequest(String sceneName, Integer sceneItemId, BlendMode sceneItemBlendMode) {
    super(RequestType.SetSceneItemBlendMode,
        Data.builder().sceneName(sceneName).sceneItemId(sceneItemId)
            .sceneItemBlendMode(sceneItemBlendMode).build());
  }

  @Getter
  @ToString
  @SuperBuilder
  static class Data extends SceneItemRequest.DataWithId {
    @NonNull
    private final SceneItem.BlendMode sceneItemBlendMode;
  }
}
