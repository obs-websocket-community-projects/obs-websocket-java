// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.config;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetStreamServiceSettingsResponse extends RequestResponse<GetStreamServiceSettingsResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Stream service type, like `rtmp_custom` or `rtmp_common`
     */
    @NonNull
    private String streamServiceType;

    /**
     * Stream service settings
     */
    @NonNull
    private JsonObject streamServiceSettings;
  }
}
