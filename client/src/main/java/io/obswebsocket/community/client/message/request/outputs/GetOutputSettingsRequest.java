package io.obswebsocket.community.client.message.request.outputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetOutputSettingsRequest extends OutputRequest<OutputRequest.Data> {

  @Builder
  private GetOutputSettingsRequest(String outputName) {
    super(Request.Data.Type.GetOutputSettings, Data.builder().outputName(outputName).build());
  }
}
