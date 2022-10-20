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
public class GetSceneItemIndexRequest extends Request<GetSceneItemIndexRequest.SpecificData> {
  @Builder
  private GetSceneItemIndexRequest(String sceneName, Number sceneItemId) {
    super(RequestType.GetSceneItemIndex, SpecificData.builder().sceneName(sceneName).sceneItemId(sceneItemId).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String sceneName;

    @NonNull
    private Number sceneItemId;
  }
}
