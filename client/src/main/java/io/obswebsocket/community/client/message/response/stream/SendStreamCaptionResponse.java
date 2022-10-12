package io.obswebsocket.community.client.message.response.stream;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SendStreamCaptionResponse extends RequestResponse<Void> {
  public SendStreamCaptionResponse() {
    super();
  }
}
