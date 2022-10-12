package io.obswebsocket.community.client.message.request.filters;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetSourceFilterRequest extends FilterRequest<GetSourceFilterRequest.Data> {
  @Builder
  private GetSourceFilterRequest(String sourceName, String filterName) {
    super(Request.Data.Type.GetSourceFilter, Data.builder().sourceName(sourceName).filterName(filterName).build());
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends FilterRequest.Data {

    @NonNull
    private final String filterName;
  }
}
