// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import io.obswebsocket.community.client.model.Input;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class SetInputAudioTracksRequest extends Request<SetInputAudioTracksRequest.SpecificData> {
  @Builder
  private SetInputAudioTracksRequest(String inputName, Input.AudioTracks inputAudioTracks) {
    super(RequestType.SetInputAudioTracks, SpecificData.builder().inputName(inputName).inputAudioTracks(inputAudioTracks).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String inputName;

    @NonNull
    private Input.AudioTracks inputAudioTracks;
  }
}
