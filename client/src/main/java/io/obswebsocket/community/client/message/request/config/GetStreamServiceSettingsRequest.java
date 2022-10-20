// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetStreamServiceSettingsRequest extends Request<Void> {
  @Builder
  private GetStreamServiceSettingsRequest() {
    super(RequestType.GetStreamServiceSettings, null);
  }
}
