package io.obswebsocket.community.client.message.response.general;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetVideoSettingsResponse extends RequestResponse<Void> {
  public SetVideoSettingsResponse() {
    super(Request.Data.Type.SetVideoSettings);
  }
}
