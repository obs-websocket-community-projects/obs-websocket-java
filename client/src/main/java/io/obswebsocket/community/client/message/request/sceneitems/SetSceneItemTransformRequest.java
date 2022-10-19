package io.obswebsocket.community.client.message.request.sceneitems;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class SetSceneItemTransformRequest extends
    Request<SetSceneItemTransformRequest.SpecificData> {

  @Builder
  private SetSceneItemTransformRequest(String sceneName, Number sceneItemId,
      JsonObject sceneItemTransform) {
    super(RequestType.SetSceneItemTransform,
        SpecificData.builder().sceneName(sceneName).sceneItemId(sceneItemId)
            .sceneItemTransform(sceneItemTransform).build());
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
    private JsonObject sceneItemTransform;
  }
}
