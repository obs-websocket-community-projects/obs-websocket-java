// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.outputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetOutputSettingsRequest extends Request<GetOutputSettingsRequest.SpecificData> {
  @Builder
  private GetOutputSettingsRequest(String outputName) {
    super(RequestType.GetOutputSettings, SpecificData.builder().outputName(outputName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String outputName;
  }
}
