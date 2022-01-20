package io.obswebsocket.community.client.message.request.outputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class StopOutputRequest extends OutputRequest {

  private final Data requestData;

  @Builder
  private StopOutputRequest(String outputName) {
    super(Request.Data.Type.StopOutput);

    this.requestData = Data.builder().outputName(outputName).build();
  }
}
