// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.outputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetReplayBufferStatusResponse extends RequestResponse<GetReplayBufferStatusResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Whether the output is active
     */
    @NonNull
    private Boolean outputActive;
  }
}
