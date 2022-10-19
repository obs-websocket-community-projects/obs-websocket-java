package io.obswebsocket.community.client.message.request.outputs;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class StartOutputRequest extends OutputRequest<OutputRequest.Data> {

  @Builder
  private StartOutputRequest(String outputName) {
    super(RequestType.StartOutput, Data.builder().outputName(outputName).build());
  }
}
