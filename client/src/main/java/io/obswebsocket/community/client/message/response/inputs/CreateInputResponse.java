package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CreateInputResponse extends RequestResponse<CreateInputResponse.Data> {
  public CreateInputResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {
    private Integer sceneItemId;
  }
}
