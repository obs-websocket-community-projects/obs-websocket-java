package io.obswebsocket.community.client.message.response.record;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetRecordFilenameFormattingResponse extends RequestResponse {

  public SetRecordFilenameFormattingResponse() {
    super(Request.Data.Type.SetRecordFilenameFormatting);
  }
}
