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
public class GetCurrentProgramSceneResponse extends RequestResponse<GetCurrentProgramSceneResponse.SpecificData> {
  /**
   * Current program scene
   *
   * @return the currentProgramSceneName
   */
  public String getCurrentProgramSceneName() {
    return getMessageData().getResponseData().getCurrentProgramSceneName();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Current program scene
     */
    private String currentProgramSceneName;
  }
}
