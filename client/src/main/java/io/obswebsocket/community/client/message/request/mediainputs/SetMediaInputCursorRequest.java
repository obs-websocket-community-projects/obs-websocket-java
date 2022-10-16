package io.obswebsocket.community.client.message.request.mediainputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.mediainputs.SetMediaInputCursorRequest.Data;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetMediaInputCursorRequest extends MediaInputRequest<Data> {

  @Builder
  private SetMediaInputCursorRequest(String inputName, long mediaCursor) {
    super(Request.Data.Type.SetMediaInputCursor,
        Data.builder().inputName(inputName).mediaCursor(mediaCursor).build());
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends MediaInputRequest.Data {

    private long mediaCursor;
  }
}
