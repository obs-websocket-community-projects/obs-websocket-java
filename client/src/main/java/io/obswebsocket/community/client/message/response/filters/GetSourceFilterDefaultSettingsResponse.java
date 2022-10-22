// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.filters;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetSourceFilterDefaultSettingsResponse extends RequestResponse<GetSourceFilterDefaultSettingsResponse.SpecificData> {
  /**
   * Object of default settings for the filter kind
   *
   * @return the defaultFilterSettings
   */
  public JsonObject getDefaultFilterSettings() {
    return getMessageData().getResponseData().getDefaultFilterSettings();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Object of default settings for the filter kind
     */
    private JsonObject defaultFilterSettings;
  }
}
