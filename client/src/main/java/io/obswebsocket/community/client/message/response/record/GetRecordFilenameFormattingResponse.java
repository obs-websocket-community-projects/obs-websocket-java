package io.obswebsocket.community.client.message.response.record;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetRecordFilenameFormattingResponse extends RequestResponse {

  private Data responseData;

  public GetRecordFilenameFormattingResponse() {
    super(Request.Data.Type.GetRecordFilenameFormatting);
  }

  @Getter
  @ToString
  public static class Data {

    private String filenameFormatting;
  }
}
