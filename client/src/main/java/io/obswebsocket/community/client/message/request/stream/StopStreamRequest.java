package io.obswebsocket.community.client.message.request.stream;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class StopStreamRequest extends Request<Void> {

  @Builder
  private StopStreamRequest() {
    super(Data.Type.StopStream, null);
  }
}
