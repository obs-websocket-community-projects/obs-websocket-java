package io.obswebsocket.community.client.message.request.general;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CloseProjectorRequest extends Request {

  private final Data requestData;

  @Builder
  private CloseProjectorRequest(String projectorName) {
    super(Request.Data.Type.CloseProjector);

    this.requestData = Data.builder().projectorName(projectorName).build();
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    @NonNull
    private final String projectorName;
  }
}
