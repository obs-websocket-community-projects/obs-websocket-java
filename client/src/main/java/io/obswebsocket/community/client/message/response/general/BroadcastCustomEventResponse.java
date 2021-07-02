package io.obswebsocket.community.client.message.response.general;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class BroadcastCustomEventResponse extends RequestResponse {

  public BroadcastCustomEventResponse() {
    super(Request.Type.BroadcastCustomEvent);
  }
}
