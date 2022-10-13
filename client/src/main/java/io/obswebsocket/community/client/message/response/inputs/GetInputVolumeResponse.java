package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputVolumeResponse extends RequestResponse<GetInputVolumeResponse.Data> {
  public GetInputVolumeResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {
    private float inputVolumeDb;
    private float inputVolumeMul;
  }
}
