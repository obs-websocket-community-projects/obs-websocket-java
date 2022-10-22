// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.scenes;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Scene;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetSceneListResponse extends RequestResponse<GetSceneListResponse.SpecificData> {
  /**
   * Current program scene
   *
   * @return the currentProgramSceneName
   */
  public String getCurrentProgramSceneName() {
    return getMessageData().getResponseData().getCurrentProgramSceneName();
  }

  /**
   * Current preview scene. `null` if not in studio mode
   *
   * @return the currentPreviewSceneName
   */
  public String getCurrentPreviewSceneName() {
    return getMessageData().getResponseData().getCurrentPreviewSceneName();
  }

  /**
   * Array of scenes
   *
   * @return the scenes
   */
  public List<Scene> getScenes() {
    return getMessageData().getResponseData().getScenes();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Current program scene
     */
    private String currentProgramSceneName;

    /**
     * Current preview scene. `null` if not in studio mode
     */
    private String currentPreviewSceneName;

    /**
     * Array of scenes
     */
    @Singular
    private List<Scene> scenes;
  }
}
