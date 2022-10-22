// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.scenes;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetCurrentPreviewSceneResponse extends RequestResponse<GetCurrentPreviewSceneResponse.SpecificData> {
  /**
   * Current preview scene
   *
   * @return the currentPreviewSceneName
   */
  public String getCurrentPreviewSceneName() {
    return getMessageData().getResponseData().getCurrentPreviewSceneName();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Current preview scene
     */
    private String currentPreviewSceneName;
  }
}
