// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.mediainputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class OffsetMediaInputCursorRequest extends Request<OffsetMediaInputCursorRequest.SpecificData> {
  @Builder
  private OffsetMediaInputCursorRequest(String inputName, Number mediaCursorOffset) {
    super(RequestType.OffsetMediaInputCursor, SpecificData.builder().inputName(inputName).mediaCursorOffset(mediaCursorOffset).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String inputName;

    @NonNull
    private Number mediaCursorOffset;
  }
}
