package io.obswebsocket.community.client.message.request.outputs;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetOutputSettingsRequest extends OutputRequest<OutputRequest.Data> {

  @Builder
  private GetOutputSettingsRequest(String outputName) {
    super(RequestType.GetOutputSettings, Data.builder().outputName(outputName).build());
  }
}
