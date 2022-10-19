package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class GetInputListRequest extends Request<GetInputListRequest.SpecificData> {
  @Builder
  private GetInputListRequest(String inputKind) {
    super(RequestType.GetInputList, SpecificData.builder().inputKind(inputKind).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    private String inputKind;
  }
}
