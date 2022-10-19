package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputListRequest extends Request<GetInputListRequest.Data> {
  @Builder
  private GetInputListRequest(String inputKind) {
    super(RequestType.GetInputList, Data.builder().inputKind(inputKind).build());
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    private final String inputKind;
  }
}
