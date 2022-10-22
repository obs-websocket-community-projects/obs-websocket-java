// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.config;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetStreamServiceSettingsResponse extends RequestResponse<GetStreamServiceSettingsResponse.SpecificData> {
  /**
   * Stream service type, like `rtmp_custom` or `rtmp_common`
   *
   * @return the streamServiceType
   */
  public String getStreamServiceType() {
    return getMessageData().getResponseData().getStreamServiceType();
  }

  /**
   * Stream service settings
   *
   * @return the streamServiceSettings
   */
  public JsonObject getStreamServiceSettings() {
    return getMessageData().getResponseData().getStreamServiceSettings();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Stream service type, like `rtmp_custom` or `rtmp_common`
     */
    private String streamServiceType;

    /**
     * Stream service settings
     */
    private JsonObject streamServiceSettings;
  }
}
