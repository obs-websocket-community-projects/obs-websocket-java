package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Input;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputAudioMonitorTypeResponse extends RequestResponse {

  private Data responseData;

  public GetInputAudioMonitorTypeResponse() {
    super(Request.Data.Type.GetInputAudioMonitorType);
  }

  @Getter
  @ToString
  public static class Data {

    private Input.MonitorType monitorType;
  }
}
