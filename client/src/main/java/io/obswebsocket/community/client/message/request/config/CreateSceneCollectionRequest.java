// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.config;

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
public class CreateSceneCollectionRequest extends Request<CreateSceneCollectionRequest.SpecificData> {
  @Builder
  private CreateSceneCollectionRequest(String sceneCollectionName) {
    super(RequestType.CreateSceneCollection, SpecificData.builder().sceneCollectionName(sceneCollectionName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String sceneCollectionName;
  }
}
