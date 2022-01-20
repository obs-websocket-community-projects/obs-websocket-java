package io.obswebsocket.community.client.message.request.filters;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSourceFilterListRequest extends FilterRequest {

  private final Data requestData;

  @Builder
  private GetSourceFilterListRequest(String sourceName) {
    super(Request.Data.Type.GetSourceFilterList);

    this.requestData = Data.builder().sourceName(sourceName).build();
  }
}
