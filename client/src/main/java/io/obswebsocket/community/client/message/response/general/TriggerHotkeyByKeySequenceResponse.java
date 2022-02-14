package io.obswebsocket.community.client.message.response.general;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class TriggerHotkeyByKeySequenceResponse extends RequestResponse {

  public TriggerHotkeyByKeySequenceResponse() {
    super(Request.Type.TriggerHotkeyByKeySequence);
  }
}
