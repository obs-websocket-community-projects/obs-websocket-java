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
public class CreateSceneRequest extends Request<CreateSceneRequest.SpecificData> {
  @Builder
  private CreateSceneRequest(String sceneName) {
    super(RequestType.CreateScene, SpecificData.builder().sceneName(sceneName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String sceneName;
  }
}
