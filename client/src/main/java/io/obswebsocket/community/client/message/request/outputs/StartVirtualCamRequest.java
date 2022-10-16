package io.obswebsocket.community.client.message.request.outputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class StartVirtualCamRequest extends Request<Void> {

  @Builder
  private StartVirtualCamRequest() {
    super(Data.Type.StartVirtualCam, null);
  }
}
