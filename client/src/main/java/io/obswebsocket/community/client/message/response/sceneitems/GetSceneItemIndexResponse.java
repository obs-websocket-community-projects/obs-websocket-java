// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.sceneitems;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetSceneItemIndexResponse extends RequestResponse<GetSceneItemIndexResponse.SpecificData> {
  /**
   * Index position of the scene item
   *
   * @return the sceneItemIndex
   */
  public Number getSceneItemIndex() {
    return getMessageData().getResponseData().getSceneItemIndex();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Index position of the scene item
     */
    private Number sceneItemIndex;
  }
}
