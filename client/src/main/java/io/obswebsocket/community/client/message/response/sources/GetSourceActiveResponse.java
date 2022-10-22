// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.sources;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetSourceActiveResponse extends RequestResponse<GetSourceActiveResponse.SpecificData> {
  /**
   * Whether the source is showing in Program
   *
   * @return the videoActive
   */
  public Boolean getVideoActive() {
    return getMessageData().getResponseData().getVideoActive();
  }

  /**
   * Whether the source is showing in the UI (Preview, Projector, Properties)
   *
   * @return the videoShowing
   */
  public Boolean getVideoShowing() {
    return getMessageData().getResponseData().getVideoShowing();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Whether the source is showing in Program
     */
    private Boolean videoActive;

    /**
     * Whether the source is showing in the UI (Preview, Projector, Properties)
     */
    private Boolean videoShowing;
  }
}
