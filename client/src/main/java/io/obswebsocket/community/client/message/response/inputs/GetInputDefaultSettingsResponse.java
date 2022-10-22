// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.inputs;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetInputDefaultSettingsResponse extends RequestResponse<GetInputDefaultSettingsResponse.SpecificData> {
  /**
   * Object of default settings for the input kind
   *
   * @return the defaultInputSettings
   */
  public JsonObject getDefaultInputSettings() {
    return getMessageData().getResponseData().getDefaultInputSettings();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Object of default settings for the input kind
     */
    private JsonObject defaultInputSettings;
  }
}
