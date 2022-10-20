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
public class SetSceneItemEnabledRequest extends Request<SetSceneItemEnabledRequest.SpecificData> {
  @Builder
  private SetSceneItemEnabledRequest(String sceneName, Number sceneItemId,
      Boolean sceneItemEnabled) {
    super(RequestType.SetSceneItemEnabled, SpecificData.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemEnabled(sceneItemEnabled).build());
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
    private Boolean sceneItemEnabled;
  }
}
