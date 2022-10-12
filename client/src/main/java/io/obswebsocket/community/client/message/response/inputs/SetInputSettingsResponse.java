package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetInputSettingsResponse extends RequestResponse<Void> {
  public SetInputSettingsResponse() {
    super();
  }
}
