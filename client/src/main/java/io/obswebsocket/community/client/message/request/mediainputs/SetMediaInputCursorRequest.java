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
public class SetMediaInputCursorRequest extends Request<SetMediaInputCursorRequest.SpecificData> {
  @Builder
  private SetMediaInputCursorRequest(String inputName, Number mediaCursor) {
    super(RequestType.SetMediaInputCursor, SpecificData.builder().inputName(inputName).mediaCursor(mediaCursor).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String inputName;

    @NonNull
    private Number mediaCursor;
  }
}
