// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.record;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class StopRecordResponse extends RequestResponse<StopRecordResponse.SpecificData> {
  /**
   * File name for the saved recording
   *
   * @return the outputPath
   */
  public String getOutputPath() {
    return getMessageData().getResponseData().getOutputPath();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * File name for the saved recording
     */
    private String outputPath;
  }
}
