package io.obswebsocket.community.client.message.request.record;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetRecordFilenameFormattingRequest extends Request {

  @Builder
  private GetRecordFilenameFormattingRequest() {
    super(Data.Type.GetRecordFilenameFormatting);
  }
}
