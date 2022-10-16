package io.obswebsocket.community.client.message.request.mediainputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.mediainputs.OffsetMediaInputCursorRequest.Data;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class OffsetMediaInputCursorRequest extends MediaInputRequest<Data> {

  @Builder
  private OffsetMediaInputCursorRequest(String inputName, long mediaCursorOffset) {
    super(Request.Data.Type.OffsetMediaInputCursor,
        Data.builder().inputName(inputName).mediaCursorOffset(mediaCursorOffset).build());
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends MediaInputRequest.Data {

    private long mediaCursorOffset;
  }
}
