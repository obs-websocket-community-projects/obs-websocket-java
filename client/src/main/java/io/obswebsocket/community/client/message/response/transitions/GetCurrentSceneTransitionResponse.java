// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.transitions;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetCurrentSceneTransitionResponse extends RequestResponse<GetCurrentSceneTransitionResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the transition
     */
    @NonNull
    private String transitionName;

    /**
     * Kind of the transition
     */
    @NonNull
    private String transitionKind;

    /**
     * Whether the transition uses a fixed (unconfigurable) duration
     */
    @NonNull
    private Boolean transitionFixed;

    /**
     * Configured transition duration in milliseconds. `null` if transition is fixed
     */
    @NonNull
    private Number transitionDuration;

    /**
     * Whether the transition supports being configured
     */
    @NonNull
    private Boolean transitionConfigurable;

    /**
     * Object of settings for the transition. `null` if transition is not configurable
     */
    @NonNull
    private JsonObject transitionSettings;
  }
}
