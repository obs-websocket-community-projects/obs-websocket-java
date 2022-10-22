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
public class GetSceneItemIdResponse extends RequestResponse<GetSceneItemIdResponse.SpecificData> {
  /**
   * Numeric ID of the scene item
   *
   * @return the sceneItemId
   */
  public Number getSceneItemId() {
    return getMessageData().getResponseData().getSceneItemId();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Numeric ID of the scene item
     */
    private Number sceneItemId;
  }
}
