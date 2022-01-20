package io.obswebsocket.community.client.message.request.stream;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SendStreamCaptionRequest extends Request {

  private final Data requestData;

  @Builder
  private SendStreamCaptionRequest(String captionText) {
    super(Request.Data.Type.SendStreamCaption);

    this.requestData = Data.builder().captionText(captionText).build();
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    @NonNull
    private final String captionText;
  }
}
