package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetInputAudioMonitorTypeResponse extends RequestResponse {

  public SetInputAudioMonitorTypeResponse() {
    super(Request.Data.Type.SetInputAudioMonitorType);
  }
}
