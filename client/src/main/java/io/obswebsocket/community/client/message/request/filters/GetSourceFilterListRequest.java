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
public class GetSourceFilterListRequest extends Request<GetSourceFilterListRequest.SpecificData> {
  @Builder
  private GetSourceFilterListRequest(String sourceName) {
    super(RequestType.GetSourceFilterList, SpecificData.builder().sourceName(sourceName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String sourceName;
  }
}
