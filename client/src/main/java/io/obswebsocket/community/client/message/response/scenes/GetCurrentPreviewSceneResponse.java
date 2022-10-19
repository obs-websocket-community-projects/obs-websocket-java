package io.obswebsocket.community.client.message.response.scenes;

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
public class GetCurrentPreviewSceneResponse extends RequestResponse<GetCurrentPreviewSceneResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Current preview scene
     */
    @NonNull
    private String currentPreviewSceneName;
  }
}
