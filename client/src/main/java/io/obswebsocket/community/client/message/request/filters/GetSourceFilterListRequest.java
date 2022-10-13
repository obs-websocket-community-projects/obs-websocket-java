package io.obswebsocket.community.client.message.request.filters;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSourceFilterListRequest extends FilterRequest<FilterRequest.Data> {
  @Builder
  private GetSourceFilterListRequest(String sourceName) {
    super(Request.Data.Type.GetSourceFilterList, Data.builder().sourceName(sourceName).build());
  }
}
