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
public class SetSourceFilterNameRequest extends Request<SetSourceFilterNameRequest.SpecificData> {
  @Builder
  private SetSourceFilterNameRequest(String sourceName, String filterName, String newFilterName) {
    super(RequestType.SetSourceFilterName, SpecificData.builder().sourceName(sourceName).filterName(filterName).newFilterName(newFilterName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String sourceName;

    @NonNull
    private String filterName;

    @NonNull
    private String newFilterName;
  }
}
