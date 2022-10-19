package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetVideoSettingsRequest extends Request<Void> {
  @Builder
  private GetVideoSettingsRequest() {
    super(RequestType.GetVideoSettings, null);
  }
}
