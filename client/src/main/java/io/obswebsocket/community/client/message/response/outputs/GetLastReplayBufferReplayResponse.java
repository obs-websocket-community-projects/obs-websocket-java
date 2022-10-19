package io.obswebsocket.community.client.message.response.outputs;

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
public class GetLastReplayBufferReplayResponse extends RequestResponse<GetLastReplayBufferReplayResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * File path
     */
    @NonNull
    private String savedReplayPath;
  }
}
