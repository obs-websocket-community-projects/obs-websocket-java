package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.AudioTracks;
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
public class GetInputAudioTracksResponse extends RequestResponse<GetInputAudioTracksResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Object of audio tracks and associated enable states
     */
    @NonNull
    private AudioTracks inputAudioTracks;
  }
}
