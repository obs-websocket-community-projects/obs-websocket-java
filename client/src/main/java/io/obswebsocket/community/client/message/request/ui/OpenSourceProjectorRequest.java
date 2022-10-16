package io.obswebsocket.community.client.message.request.ui;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class OpenSourceProjectorRequest extends Request<OpenSourceProjectorRequest.Data> {

  @Builder
  private OpenSourceProjectorRequest(String sourceName, Integer monitorIndex,
      String projectorGeometry) {
    super(Request.Data.Type.OpenSourceProjector, Data.builder()
        .sourceName(sourceName)
        .monitorIndex(monitorIndex)
        .projectorGeometry(projectorGeometry)
        .build());
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    @NonNull
    private final String sourceName;
    private final Integer monitorIndex;
    private final String projectorGeometry;
  }
}
