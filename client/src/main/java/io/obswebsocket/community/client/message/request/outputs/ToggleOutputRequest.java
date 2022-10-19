package io.obswebsocket.community.client.message.request.outputs;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ToggleOutputRequest extends OutputRequest<OutputRequest.Data> {
  @Builder
  private ToggleOutputRequest(String outputName) {
    super(RequestType.ToggleOutput, Data.builder().outputName(outputName).build());
  }
}
