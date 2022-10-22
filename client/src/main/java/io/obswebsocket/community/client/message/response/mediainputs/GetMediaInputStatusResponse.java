// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.mediainputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.MediaState;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetMediaInputStatusResponse extends RequestResponse<GetMediaInputStatusResponse.SpecificData> {
  /**
   * State of the media input
   *
   * @return the mediaState
   */
  public MediaState getMediaState() {
    return getMessageData().getResponseData().getMediaState();
  }

  /**
   * Total duration of the playing media in milliseconds. `null` if not playing
   *
   * @return the mediaDuration
   */
  public Number getMediaDuration() {
    return getMessageData().getResponseData().getMediaDuration();
  }

  /**
   * Position of the cursor in milliseconds. `null` if not playing
   *
   * @return the mediaCursor
   */
  public Number getMediaCursor() {
    return getMessageData().getResponseData().getMediaCursor();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * State of the media input
     */
    private MediaState mediaState;

    /**
     * Total duration of the playing media in milliseconds. `null` if not playing
     */
    private Number mediaDuration;

    /**
     * Position of the cursor in milliseconds. `null` if not playing
     */
    private Number mediaCursor;
  }
}
