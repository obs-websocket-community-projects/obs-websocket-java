// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class SetSceneItemIndexRequest extends Request<SetSceneItemIndexRequest.SpecificData> {
  @Builder
  private SetSceneItemIndexRequest(String sceneName, Number sceneItemId, Number sceneItemIndex) {
    super(RequestType.SetSceneItemIndex, SpecificData.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemIndex(sceneItemIndex).build());
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
    private Number sceneItemIndex;
  }
}
