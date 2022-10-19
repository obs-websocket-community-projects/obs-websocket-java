package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
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
public class GetInputAudioTracksRequest extends Request<GetInputAudioTracksRequest.SpecificData> {
  @Builder
  private GetInputAudioTracksRequest(String inputName) {
    super(RequestType.GetInputAudioTracks, SpecificData.builder().inputName(inputName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String inputName;
  }
}
