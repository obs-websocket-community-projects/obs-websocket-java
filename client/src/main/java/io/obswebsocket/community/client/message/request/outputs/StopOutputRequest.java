package io.obswebsocket.community.client.message.request.outputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class StopOutputRequest extends OutputRequest<OutputRequest.Data> {

  @Builder
  private StopOutputRequest(String outputName) {
    super(Request.Data.Type.StopOutput, Data.builder().outputName(outputName).build());
  }
}
