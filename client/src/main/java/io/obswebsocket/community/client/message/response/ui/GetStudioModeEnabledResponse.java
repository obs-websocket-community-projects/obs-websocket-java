// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.ui;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetStudioModeEnabledResponse extends RequestResponse<GetStudioModeEnabledResponse.SpecificData> {
  /**
   * Whether studio mode is enabled
   *
   * @return the studioModeEnabled
   */
  public Boolean getStudioModeEnabled() {
    return getMessageData().getResponseData().getStudioModeEnabled();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Whether studio mode is enabled
     */
    private Boolean studioModeEnabled;
  }
}
