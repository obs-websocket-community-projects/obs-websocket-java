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
public class GetCurrentSceneTransitionResponse extends RequestResponse<GetCurrentSceneTransitionResponse.SpecificData> {
  /**
   * Name of the transition
   *
   * @return the transitionName
   */
  public String getTransitionName() {
    return getMessageData().getResponseData().getTransitionName();
  }

  /**
   * Kind of the transition
   *
   * @return the transitionKind
   */
  public String getTransitionKind() {
    return getMessageData().getResponseData().getTransitionKind();
  }

  /**
   * Whether the transition uses a fixed (unconfigurable) duration
   *
   * @return the transitionFixed
   */
  public Boolean getTransitionFixed() {
    return getMessageData().getResponseData().getTransitionFixed();
  }

  /**
   * Configured transition duration in milliseconds. `null` if transition is fixed
   *
   * @return the transitionDuration
   */
  public Number getTransitionDuration() {
    return getMessageData().getResponseData().getTransitionDuration();
  }

  /**
   * Whether the transition supports being configured
   *
   * @return the transitionConfigurable
   */
  public Boolean getTransitionConfigurable() {
    return getMessageData().getResponseData().getTransitionConfigurable();
  }

  /**
   * Object of settings for the transition. `null` if transition is not configurable
   *
   * @return the transitionSettings
   */
  public JsonObject getTransitionSettings() {
    return getMessageData().getResponseData().getTransitionSettings();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the transition
     */
    private String transitionName;

    /**
     * Kind of the transition
     */
    private String transitionKind;

    /**
     * Whether the transition uses a fixed (unconfigurable) duration
     */
    private Boolean transitionFixed;

    /**
     * Configured transition duration in milliseconds. `null` if transition is fixed
     */
    private Number transitionDuration;

    /**
     * Whether the transition supports being configured
     */
    private Boolean transitionConfigurable;

    /**
     * Object of settings for the transition. `null` if transition is not configurable
     */
    private JsonObject transitionSettings;
  }
}
