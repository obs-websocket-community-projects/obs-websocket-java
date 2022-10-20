package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import io.obswebsocket.community.client.model.Input.AudioTracks;
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
public class SetInputAudioTracksRequest extends Request<SetInputAudioTracksRequest.SpecificData> {
  @Builder
  private SetInputAudioTracksRequest(String inputName, AudioTracks inputAudioTracks) {
    super(RequestType.SetInputAudioTracks, SpecificData.builder().inputName(inputName).inputAudioTracks(inputAudioTracks).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String inputName;

    @NonNull
    private AudioTracks inputAudioTracks;
  }
}
