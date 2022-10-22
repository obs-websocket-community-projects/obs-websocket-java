// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.sources;

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
public class GetSourceActiveRequest extends Request<GetSourceActiveRequest.SpecificData> {
  @Builder
  private GetSourceActiveRequest(String sourceName) {
    super(RequestType.GetSourceActive, SpecificData.builder().sourceName(sourceName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String sourceName;
  }
}
