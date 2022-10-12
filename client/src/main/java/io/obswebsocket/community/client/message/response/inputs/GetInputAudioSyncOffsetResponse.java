package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetInputAudioSyncOffsetResponse extends RequestResponse<GetInputAudioSyncOffsetResponse.Data> {
  public GetInputAudioSyncOffsetResponse() {
    super(Request.Data.Type.GetInputAudioSyncOffset);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private Long inputAudioSyncOffset;
  }
}
