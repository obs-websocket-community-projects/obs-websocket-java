package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputListRequest extends Request {

  private final Data requestData;

  @Builder
  private GetInputListRequest(String inputKind) {
    super(Type.GetInputList);

    this.requestData = Data.builder().inputKind(inputKind).build();
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    private final String inputKind;
  }
}
