package io.obswebsocket.community.client.message.response.scenes;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class GetSceneSceneTransitionOverrideResponse extends RequestResponse<GetSceneSceneTransitionOverrideResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the overridden scene transition, else `null`
     */
    @NonNull
    private String transitionName;

    /**
     * Duration of the overridden scene transition, else `null`
     */
    @NonNull
    private Number transitionDuration;
  }
}
