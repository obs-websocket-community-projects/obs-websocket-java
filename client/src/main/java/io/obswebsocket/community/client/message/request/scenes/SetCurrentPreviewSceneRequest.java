// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.scenes;

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
public class SetCurrentPreviewSceneRequest extends Request<SetCurrentPreviewSceneRequest.SpecificData> {
  @Builder
  private SetCurrentPreviewSceneRequest(String sceneName) {
    super(RequestType.SetCurrentPreviewScene, SpecificData.builder().sceneName(sceneName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String sceneName;
  }
}
