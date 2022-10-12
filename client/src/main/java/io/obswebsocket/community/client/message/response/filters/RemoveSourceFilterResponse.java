package io.obswebsocket.community.client.message.response.filters;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RemoveSourceFilterResponse extends RequestResponse<Void> {
  public RemoveSourceFilterResponse() {
    super(Request.Data.Type.RemoveSourceFilter);
  }
}
