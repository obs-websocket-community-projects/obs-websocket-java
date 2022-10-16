package io.obswebsocket.community.client.message.response.outputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ToggleVirtualCamResponse extends RequestResponse<ToggleVirtualCamResponse.Data> {

  public ToggleVirtualCamResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {

    private boolean outputActive;
  }
}
