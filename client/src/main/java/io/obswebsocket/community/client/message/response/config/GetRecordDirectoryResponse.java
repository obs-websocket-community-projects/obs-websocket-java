// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.config;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetRecordDirectoryResponse extends RequestResponse<GetRecordDirectoryResponse.SpecificData> {
  /**
   * Output directory
   *
   * @return the recordDirectory
   */
  public String getRecordDirectory() {
    return getMessageData().getResponseData().getRecordDirectory();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Output directory
     */
    private String recordDirectory;
  }
}
