// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.config;

import io.obswebsocket.community.client.message.response.RequestResponse;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetSceneCollectionListResponse extends RequestResponse<GetSceneCollectionListResponse.SpecificData> {
  /**
   * The name of the current scene collection
   *
   * @return the currentSceneCollectionName
   */
  public String getCurrentSceneCollectionName() {
    return getMessageData().getResponseData().getCurrentSceneCollectionName();
  }

  /**
   * Array of all available scene collections
   *
   * @return the sceneCollections
   */
  public List<String> getSceneCollections() {
    return getMessageData().getResponseData().getSceneCollections();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * The name of the current scene collection
     */
    private String currentSceneCollectionName;

    /**
     * Array of all available scene collections
     */
    @Singular
    private List<String> sceneCollections;
  }
}
