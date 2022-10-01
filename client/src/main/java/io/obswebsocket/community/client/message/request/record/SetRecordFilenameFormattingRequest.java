package io.obswebsocket.community.client.message.request.record;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetRecordFilenameFormattingRequest extends Request<SetRecordFilenameFormattingRequest.Data> {
  @Builder
  private SetRecordFilenameFormattingRequest(String filenameFormatting) {
    super(Request.Data.Type.SetRecordFilenameFormatting, Data.builder().filenameFormatting(filenameFormatting).build());
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    @NonNull
    private final String filenameFormatting;
  }
}
