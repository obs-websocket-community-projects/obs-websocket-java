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
public class DuplicateSceneItemRequest extends Request<DuplicateSceneItemRequest.SpecificData> {
  @Builder
  private DuplicateSceneItemRequest(String sceneName, Number sceneItemId,
      String destinationSceneName) {
    super(RequestType.DuplicateSceneItem, SpecificData.builder().sceneName(sceneName).sceneItemId(sceneItemId).destinationSceneName(destinationSceneName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String sceneName;

    @NonNull
    private Number sceneItemId;

    private String destinationSceneName;
  }
}
