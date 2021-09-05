package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputAudioSyncOffsetResponse extends RequestResponse {

  private Data responseData;

  public GetInputAudioSyncOffsetResponse() {
    super(Request.Type.GetInputAudioSyncOffset);
  }

  @Getter
  @ToString
  public static class Data {

    private Integer inputAudioSyncOffset;
  }
}
