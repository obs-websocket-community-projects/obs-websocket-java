package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Input;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputAudioMonitorTypeResponse extends RequestResponse<GetInputAudioMonitorTypeResponse.Data> {
  public GetInputAudioMonitorTypeResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {
    private Input.MonitorType monitorType;
  }
}
