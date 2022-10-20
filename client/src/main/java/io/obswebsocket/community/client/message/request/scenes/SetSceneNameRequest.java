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
public class SetSceneNameRequest extends Request<SetSceneNameRequest.SpecificData> {
  @Builder
  private SetSceneNameRequest(String sceneName, String newSceneName) {
    super(RequestType.SetSceneName, SpecificData.builder().sceneName(sceneName).newSceneName(newSceneName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String sceneName;

    @NonNull
    private String newSceneName;
  }
}
