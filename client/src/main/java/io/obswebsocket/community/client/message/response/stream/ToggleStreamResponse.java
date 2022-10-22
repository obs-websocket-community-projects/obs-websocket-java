// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.stream;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class ToggleStreamResponse extends RequestResponse<ToggleStreamResponse.SpecificData> {
  /**
   * New state of the stream output
   *
   * @return the outputActive
   */
  public Boolean getOutputActive() {
    return getMessageData().getResponseData().getOutputActive();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * New state of the stream output
     */
    private Boolean outputActive;
  }
}
