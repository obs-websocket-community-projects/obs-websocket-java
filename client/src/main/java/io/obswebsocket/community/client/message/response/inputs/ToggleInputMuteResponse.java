package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ToggleInputMuteResponse extends RequestResponse {

  private Data responseData;

  public ToggleInputMuteResponse() {
    super(Request.Data.Type.ToggleInputMute);
  }

  @Getter
  @ToString
  public static class Data {

    private Boolean inputMuted;
  }
}
