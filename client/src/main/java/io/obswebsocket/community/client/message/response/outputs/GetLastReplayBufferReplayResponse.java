// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.outputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetLastReplayBufferReplayResponse extends RequestResponse<GetLastReplayBufferReplayResponse.SpecificData> {
  /**
   * File path
   *
   * @return the savedReplayPath
   */
  public String getSavedReplayPath() {
    return getMessageData().getResponseData().getSavedReplayPath();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * File path
     */
    private String savedReplayPath;
  }
}
