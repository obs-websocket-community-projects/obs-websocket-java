package io.obswebsocket.community.client.message.request.outputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetOutputStatusRequest extends Request<GetOutputStatusRequest.Data> {

  @Builder
  private GetOutputStatusRequest(String outputName) {
    super(RequestType.GetOutputStatus, Data.builder().outputName(outputName).build());
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    @NonNull
    private final String outputName;
  }
}
