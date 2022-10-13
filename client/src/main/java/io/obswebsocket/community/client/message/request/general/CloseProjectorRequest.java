package io.obswebsocket.community.client.message.request.general;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CloseProjectorRequest extends Request<CloseProjectorRequest.Data> {
  @Builder
  private CloseProjectorRequest(String projectorName) {
    super(Request.Data.Type.CloseProjector, Data.builder().projectorName(projectorName).build());
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    @NonNull
    private final String projectorName;
  }
}
