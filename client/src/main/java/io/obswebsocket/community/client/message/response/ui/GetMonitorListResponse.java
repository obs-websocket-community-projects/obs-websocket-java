// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.ui;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Monitor;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetMonitorListResponse extends RequestResponse<GetMonitorListResponse.SpecificData> {
  /**
   * a list of detected monitors with some information
   *
   * @return the monitors
   */
  public List<Monitor> getMonitors() {
    return getMessageData().getResponseData().getMonitors();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * a list of detected monitors with some information
     */
    @Singular
    private List<Monitor> monitors;
  }
}
