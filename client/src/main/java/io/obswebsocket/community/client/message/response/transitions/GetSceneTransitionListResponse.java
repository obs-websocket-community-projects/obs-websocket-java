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
public class GetSceneTransitionListResponse extends RequestResponse<GetSceneTransitionListResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the current scene transition. Can be null
     */
    @NonNull
    private String currentSceneTransitionName;

    /**
     * Kind of the current scene transition. Can be null
     */
    @NonNull
    private String currentSceneTransitionKind;

    /**
     * Array of transitions
     */
    @NonNull
    private JsonObject transitions;
  }
}
