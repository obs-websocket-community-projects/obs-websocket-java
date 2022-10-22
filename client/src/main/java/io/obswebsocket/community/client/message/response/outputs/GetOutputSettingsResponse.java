// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.outputs;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetOutputSettingsResponse extends RequestResponse<GetOutputSettingsResponse.SpecificData> {
  /**
   * Output settings
   *
   * @return the outputSettings
   */
  public JsonObject getOutputSettings() {
    return getMessageData().getResponseData().getOutputSettings();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Output settings
     */
    private JsonObject outputSettings;
  }
}
