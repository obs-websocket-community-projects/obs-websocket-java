// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.ui;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetMonitorListRequest extends Request<Void> {
  @Builder
  private GetMonitorListRequest() {
    super(RequestType.GetMonitorList, null);
  }
}
