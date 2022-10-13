package io.obswebsocket.community.client.message.request.sources;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSourceListRequest extends Request<Void> {

  @Builder
  private GetSourceListRequest() {
    super(Request.Data.Type.GetSourceList, null);
  }
}
