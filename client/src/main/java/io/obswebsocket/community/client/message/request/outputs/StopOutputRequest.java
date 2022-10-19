package io.obswebsocket.community.client.message.request.outputs;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class StopOutputRequest extends OutputRequest<OutputRequest.Data> {

  @Builder
  private StopOutputRequest(String outputName) {
    super(RequestType.StopOutput, Data.builder().outputName(outputName).build());
  }
}
