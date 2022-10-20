// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.stream;

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
public class SendStreamCaptionRequest extends Request<SendStreamCaptionRequest.SpecificData> {
  @Builder
  private SendStreamCaptionRequest(String captionText) {
    super(RequestType.SendStreamCaption, SpecificData.builder().captionText(captionText).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String captionText;
  }
}
