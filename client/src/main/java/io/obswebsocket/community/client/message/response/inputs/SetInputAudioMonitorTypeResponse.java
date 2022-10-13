package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetInputAudioMonitorTypeResponse extends RequestResponse<Void> {
  public SetInputAudioMonitorTypeResponse() {
    super();
  }
}
