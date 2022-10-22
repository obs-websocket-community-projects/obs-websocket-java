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
public class GetSceneSceneTransitionOverrideResponse extends RequestResponse<GetSceneSceneTransitionOverrideResponse.SpecificData> {
  /**
   * Name of the overridden scene transition, else `null`
   *
   * @return the transitionName
   */
  public String getTransitionName() {
    return getMessageData().getResponseData().getTransitionName();
  }

  /**
   * Duration of the overridden scene transition, else `null`
   *
   * @return the transitionDuration
   */
  public Number getTransitionDuration() {
    return getMessageData().getResponseData().getTransitionDuration();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the overridden scene transition, else `null`
     */
    private String transitionName;

    /**
     * Duration of the overridden scene transition, else `null`
     */
    private Number transitionDuration;
  }
}
