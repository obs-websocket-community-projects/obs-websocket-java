package io.obswebsocket.community.client.message.response.sceneitems;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.response.RequestResponse;
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
public class GetSceneItemTransformResponse extends RequestResponse<GetSceneItemTransformResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Object containing scene item transform info
     */
    @NonNull
    private JsonObject sceneItemTransform;
  }
}
