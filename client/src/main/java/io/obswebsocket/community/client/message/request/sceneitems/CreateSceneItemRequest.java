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
public class CreateSceneItemRequest extends Request<CreateSceneItemRequest.SpecificData> {
  @Builder
  private CreateSceneItemRequest(String sceneName, String sourceName, Boolean sceneItemEnabled) {
    super(RequestType.CreateSceneItem, SpecificData.builder().sceneName(sceneName).sourceName(sourceName).sceneItemEnabled(sceneItemEnabled).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String sceneName;

    @NonNull
    private String sourceName;

    private Boolean sceneItemEnabled;
  }
}
