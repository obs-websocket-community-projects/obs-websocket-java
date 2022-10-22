// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Input;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetInputAudioMonitorTypeResponse extends RequestResponse<GetInputAudioMonitorTypeResponse.SpecificData> {
  /**
   * Audio monitor type
   *
   * @return the monitorType
   */
  public Input.MonitorType getMonitorType() {
    return getMessageData().getResponseData().getMonitorType();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Audio monitor type
     */
    private Input.MonitorType monitorType;
  }
}
