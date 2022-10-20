// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.scenes;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Scene;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetSceneListResponse extends RequestResponse<GetSceneListResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Current program scene
     */
    @NonNull
    private String currentProgramSceneName;

    /**
     * Current preview scene. `null` if not in studio mode
     */
    @NonNull
    private String currentPreviewSceneName;

    /**
     * Array of scenes
     */
    @NonNull
    @Singular
    private List<Scene> scenes;
  }
}
