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
public class GetInputSettingsResponse extends RequestResponse<GetInputSettingsResponse.SpecificData> {
  /**
   * Object of settings for the input
   *
   * @return the inputSettings
   */
  public JsonObject getInputSettings() {
    return getMessageData().getResponseData().getInputSettings();
  }

  /**
   * The kind of the input
   *
   * @return the inputKind
   */
  public String getInputKind() {
    return getMessageData().getResponseData().getInputKind();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Object of settings for the input
     */
    private JsonObject inputSettings;

    /**
     * The kind of the input
     */
    private String inputKind;
  }
}
