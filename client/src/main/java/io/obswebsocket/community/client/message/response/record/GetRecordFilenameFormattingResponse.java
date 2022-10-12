package io.obswebsocket.community.client.message.response.record;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetRecordFilenameFormattingResponse extends RequestResponse<Void> {
  public GetRecordFilenameFormattingResponse() {
    super(Request.Data.Type.GetRecordFilenameFormatting);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private String filenameFormatting;
  }
}
