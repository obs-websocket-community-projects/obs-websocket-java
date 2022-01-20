package io.obswebsocket.community.client.message.request.sources;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSourceActiveRequest extends SourceRequest {

  private final Data requestData;

  @Builder
  private GetSourceActiveRequest(String sourceName) {
    super(Request.Data.Type.GetSourceActive);

    this.requestData = Data.builder().sourceName(sourceName).build();
  }
}
