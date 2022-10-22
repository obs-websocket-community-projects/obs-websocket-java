// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.sceneitems;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.SceneItem;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetSceneItemListResponse extends RequestResponse<GetSceneItemListResponse.SpecificData> {
  /**
   * Array of scene items in the scene
   *
   * @return the sceneItems
   */
  public List<SceneItem> getSceneItems() {
    return getMessageData().getResponseData().getSceneItems();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Array of scene items in the scene
     */
    @Singular
    private List<SceneItem> sceneItems;
  }
}
