package io.obswebsocket.community.client.message.response.transitions;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetCurrentTransitionDurationResponse extends RequestResponse<Void> {
  public SetCurrentTransitionDurationResponse() {
    super(Request.Data.Type.SetCurrentTransitionDuration);
  }
}
