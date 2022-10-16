package io.obswebsocket.community.client.message.response.outputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetVirtualCamStatusResponse extends RequestResponse<GetVirtualCamStatusResponse.Data> {

  public GetVirtualCamStatusResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {

    private boolean outputActive;
  }
}
