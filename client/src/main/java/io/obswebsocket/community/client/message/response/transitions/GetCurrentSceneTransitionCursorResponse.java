// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.transitions;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetCurrentSceneTransitionCursorResponse extends RequestResponse<GetCurrentSceneTransitionCursorResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Cursor position, between 0.0 and 1.0
     */
    @NonNull
    private Number transitionCursor;
  }
}
