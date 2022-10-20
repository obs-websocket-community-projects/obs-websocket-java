// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.ui;

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
public class OpenSourceProjectorRequest extends Request<OpenSourceProjectorRequest.SpecificData> {
  @Builder
  private OpenSourceProjectorRequest(String sourceName, Number monitorIndex,
      String projectorGeometry) {
    super(RequestType.OpenSourceProjector, SpecificData.builder().sourceName(sourceName).monitorIndex(monitorIndex).projectorGeometry(projectorGeometry).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String sourceName;

    private Number monitorIndex;

    private String projectorGeometry;
  }
}
