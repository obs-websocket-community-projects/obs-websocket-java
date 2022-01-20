package io.obswebsocket.community.client.message.response.inputs;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputAudioTracksResponse extends RequestResponse {

  private Data responseData;

  public GetInputAudioTracksResponse() {
    super(Request.Data.Type.GetInputAudioTracks);
  }

  @Getter
  @ToString
  public static class Data {

    // TODO: investigate exact type
    private JsonObject inputAudioTracks;
  }
}
