package io.obswebsocket.community.client.message.request.sources;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSourceActiveRequest extends SourceRequest<SourceRequest.Data> {
  @Builder
  private GetSourceActiveRequest(String sourceName) {
    super(Request.Data.Type.GetSourceActive, Data.builder().sourceName(sourceName).build());
  }
}
