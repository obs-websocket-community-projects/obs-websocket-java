package io.obswebsocket.community.client.message.response.stream;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SendStreamCaptionResponse extends RequestResponse {

  public SendStreamCaptionResponse() {
    super(Request.Type.SendStreamCaption);
  }
}
