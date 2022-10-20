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
public class SetSceneItemTransformRequest extends Request<SetSceneItemTransformRequest.SpecificData> {
  @Builder
  private SetSceneItemTransformRequest(String sceneName, Number sceneItemId,
      SceneItem.Transform sceneItemTransform) {
    super(RequestType.SetSceneItemTransform, SpecificData.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemTransform(sceneItemTransform).build());
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
    private SceneItem.Transform sceneItemTransform;
  }
}
