// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.transitions;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetSceneTransitionListResponse extends RequestResponse<GetSceneTransitionListResponse.SpecificData> {
  /**
   * Name of the current scene transition. Can be null
   *
   * @return the currentSceneTransitionName
   */
  public String getCurrentSceneTransitionName() {
    return getMessageData().getResponseData().getCurrentSceneTransitionName();
  }

  /**
   * Kind of the current scene transition. Can be null
   *
   * @return the currentSceneTransitionKind
   */
  public String getCurrentSceneTransitionKind() {
    return getMessageData().getResponseData().getCurrentSceneTransitionKind();
  }

  /**
   * Array of transitions
   *
   * @return the transitions
   */
  public JsonObject getTransitions() {
    return getMessageData().getResponseData().getTransitions();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the current scene transition. Can be null
     */
    private String currentSceneTransitionName;

    /**
     * Kind of the current scene transition. Can be null
     */
    private String currentSceneTransitionKind;

    /**
     * Array of transitions
     */
    private JsonObject transitions;
  }
}
