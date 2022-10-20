// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import io.obswebsocket.community.client.model.SceneItem;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class SetSceneItemBlendModeRequest extends Request<SetSceneItemBlendModeRequest.SpecificData> {
  @Builder
  private SetSceneItemBlendModeRequest(String sceneName, Number sceneItemId,
      SceneItem.BlendMode sceneItemBlendMode) {
    super(RequestType.SetSceneItemBlendMode, SpecificData.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemBlendMode(sceneItemBlendMode).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String sceneName;

    @NonNull
    private Number sceneItemId;

    @NonNull
    private SceneItem.BlendMode sceneItemBlendMode;
  }
}
