package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetSceneItemEnabledRequest extends SceneItemRequest<SetSceneItemEnabledRequest.Data> {
  @Builder
  private SetSceneItemEnabledRequest(String sceneName, Integer sceneItemId,
          Boolean sceneItemEnabled) {
    super(RequestType.SetSceneItemEnabled,
        Data.builder().sceneName(sceneName).sceneItemId(sceneItemId)
            .sceneItemEnabled(sceneItemEnabled).build());
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends SceneItemRequest.DataWithId {

    @NonNull
    private final Boolean sceneItemEnabled;
  }
}
