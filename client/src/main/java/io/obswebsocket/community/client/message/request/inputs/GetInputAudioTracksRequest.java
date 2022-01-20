package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputAudioTracksRequest extends InputRequest {

  private final Data requestData;

  @Builder
  private GetInputAudioTracksRequest(String inputName) {
    super(Request.Data.Type.GetInputAudioTracks);

    this.requestData = Data.builder().inputName(inputName).build();
  }
}
