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
public class GetSceneItemBlendModeResponse extends RequestResponse<GetSceneItemBlendModeResponse.SpecificData> {
  /**
   * Current blend mode
   *
   * @return the sceneItemBlendMode
   */
  public String getSceneItemBlendMode() {
    return getMessageData().getResponseData().getSceneItemBlendMode();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Current blend mode
     */
    private String sceneItemBlendMode;
  }
}
