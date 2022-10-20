// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import io.obswebsocket.community.client.model.Input;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class SetInputAudioMonitorTypeRequest extends Request<SetInputAudioMonitorTypeRequest.SpecificData> {
  @Builder
  private SetInputAudioMonitorTypeRequest(String inputName, Input.MonitorType monitorType) {
    super(RequestType.SetInputAudioMonitorType, SpecificData.builder().inputName(inputName).monitorType(monitorType).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String inputName;

    @NonNull
    private Input.MonitorType monitorType;
  }
}
