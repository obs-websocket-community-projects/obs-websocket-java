package io.obswebsocket.community.client.message.response.stream;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetStreamServiceSettingsResponse extends RequestResponse<Void> {
  public SetStreamServiceSettingsResponse() {
    super(Request.Data.Type.SetStreamServiceSettings);
  }
}
