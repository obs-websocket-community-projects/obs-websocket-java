package io.obswebsocket.community.client.message.response.record;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetRecordDirectoryResponse extends RequestResponse {

  public SetRecordDirectoryResponse() {
    super(Request.Type.SetRecordDirectory);
  }
}
