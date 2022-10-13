package io.obswebsocket.community.client.message.response.inputs;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.response.RequestResponse;
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
    // TODO: investigate exact type
    private JsonObject inputAudioTracks;
  }
}
