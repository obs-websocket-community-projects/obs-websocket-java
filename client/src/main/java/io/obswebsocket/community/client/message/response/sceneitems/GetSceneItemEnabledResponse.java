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
public class GetSceneItemEnabledResponse extends RequestResponse<GetSceneItemEnabledResponse.SpecificData> {
  /**
   * Whether the scene item is enabled. `true` for enabled, `false` for disabled
   *
   * @return the sceneItemEnabled
   */
  public Boolean getSceneItemEnabled() {
    return getMessageData().getResponseData().getSceneItemEnabled();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Whether the scene item is enabled. `true` for enabled, `false` for disabled
     */
    private Boolean sceneItemEnabled;
  }
}
