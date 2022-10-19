package io.obswebsocket.community.client.message.request.outputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class ToggleOutputRequest extends Request<ToggleOutputRequest.SpecificData> {

  @Builder
  private ToggleOutputRequest(String outputName) {
    super(RequestType.ToggleOutput, SpecificData.builder().outputName(outputName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {

    @NonNull
    private String outputName;
  }
}
