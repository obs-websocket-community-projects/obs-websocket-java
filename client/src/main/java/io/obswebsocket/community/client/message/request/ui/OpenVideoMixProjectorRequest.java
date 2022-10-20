// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.ui;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import io.obswebsocket.community.client.model.VideoMixType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class OpenVideoMixProjectorRequest extends Request<OpenVideoMixProjectorRequest.SpecificData> {
  @Builder
  private OpenVideoMixProjectorRequest(VideoMixType videoMixType, Number monitorIndex,
      String projectorGeometry) {
    super(RequestType.OpenVideoMixProjector, SpecificData.builder().videoMixType(videoMixType).monitorIndex(monitorIndex).projectorGeometry(projectorGeometry).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private VideoMixType videoMixType;

    private Number monitorIndex;

    private String projectorGeometry;
  }
}
