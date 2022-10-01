package io.obswebsocket.community.client.message.response.stream;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class StopStreamResponse extends RequestResponse<Void> {
  public StopStreamResponse() {
    super(Request.Data.Type.StopStream);
  }
}
