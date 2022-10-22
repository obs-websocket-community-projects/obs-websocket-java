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
public class GetSceneItemLockedResponse extends RequestResponse<GetSceneItemLockedResponse.SpecificData> {
  /**
   * Whether the scene item is locked. `true` for locked, `false` for unlocked
   *
   * @return the sceneItemLocked
   */
  public Boolean getSceneItemLocked() {
    return getMessageData().getResponseData().getSceneItemLocked();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Whether the scene item is locked. `true` for locked, `false` for unlocked
     */
    private Boolean sceneItemLocked;
  }
}
