package io.obswebsocket.community.client.message.request.transitions;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ReleaseTbarRequest extends Request<Void> {

  @Builder
  private ReleaseTbarRequest() {
    super(RequestType.ReleaseTbar, null);
  }
}
