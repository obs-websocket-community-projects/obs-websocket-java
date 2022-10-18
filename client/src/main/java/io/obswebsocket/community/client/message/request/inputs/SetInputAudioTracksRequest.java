package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.model.Input;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetInputAudioTracksRequest extends InputRequest<SetInputAudioTracksRequest.Data> {
  @Builder
  private SetInputAudioTracksRequest(String inputName, Input.AudioTracks inputAudioTracks) {
    super(Request.Data.Type.SetInputAudioTracks, Data.builder()
        .inputName(inputName)
        .inputAudioTracks(inputAudioTracks)
        .build());
  }

  @SuperBuilder
  public static class Data extends InputRequest.Data {
    private Input.AudioTracks inputAudioTracks;
  }
}
