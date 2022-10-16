package io.obswebsocket.community.client.message.request.ui;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetMonitorListRequest extends Request<Void> {

  @Builder
  private GetMonitorListRequest() {
    super(Request.Data.Type.GetMonitorList, null);
  }
}
