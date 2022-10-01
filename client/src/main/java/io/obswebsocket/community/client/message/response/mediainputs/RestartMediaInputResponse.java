package io.obswebsocket.community.client.message.response.mediainputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RestartMediaInputResponse extends RequestResponse<Void> {
  public RestartMediaInputResponse() {
    super(Request.Data.Type.RestartMediaInput);
  }
}
