package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.model.AudioTracks;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetInputAudioTracksRequest extends InputRequest<SetInputAudioTracksRequest.Data> {

  @Builder
  private SetInputAudioTracksRequest(String inputName, AudioTracks inputAudioTracks) {
    super(null, Data.builder()
        .inputName(inputName)
        .inputAudioTracks(inputAudioTracks)
        .build());
  }

  @SuperBuilder
  public static class Data extends InputRequest.Data {

    private AudioTracks inputAudioTracks;
  }
}
