// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.filters;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetSourceFilterRequest extends Request<GetSourceFilterRequest.SpecificData> {
  @Builder
  private GetSourceFilterRequest(String sourceName, String filterName) {
    super(RequestType.GetSourceFilter, SpecificData.builder().sourceName(sourceName).filterName(filterName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String sourceName;

    @NonNull
    private String filterName;
  }
}
