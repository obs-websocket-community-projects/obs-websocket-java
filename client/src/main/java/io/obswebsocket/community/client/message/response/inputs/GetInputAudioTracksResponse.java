package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.AudioTracks;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetInputAudioTracksResponse extends RequestResponse<GetInputAudioTracksResponse.Data> {
  public GetInputAudioTracksResponse() {
    super();
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {

    private AudioTracks inputAudioTracks;
  }
}
