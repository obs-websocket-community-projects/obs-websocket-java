// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Input;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetInputAudioTracksResponse extends RequestResponse<GetInputAudioTracksResponse.SpecificData> {
  /**
   * Object of audio tracks and associated enable states
   *
   * @return the inputAudioTracks
   */
  public Input.AudioTracks getInputAudioTracks() {
    return getMessageData().getResponseData().getInputAudioTracks();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Object of audio tracks and associated enable states
     */
    private Input.AudioTracks inputAudioTracks;
  }
}
