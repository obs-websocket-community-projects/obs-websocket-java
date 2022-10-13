package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputAudioSyncOffsetResponse extends RequestResponse<GetInputAudioSyncOffsetResponse.Data> {
  public GetInputAudioSyncOffsetResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {
    private Long inputAudioSyncOffset;
  }
}
