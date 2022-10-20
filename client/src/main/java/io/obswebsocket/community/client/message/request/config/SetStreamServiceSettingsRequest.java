// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.config;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class SetStreamServiceSettingsRequest extends Request<SetStreamServiceSettingsRequest.SpecificData> {
  @Builder
  private SetStreamServiceSettingsRequest(String streamServiceType,
      JsonObject streamServiceSettings) {
    super(RequestType.SetStreamServiceSettings, SpecificData.builder().streamServiceType(streamServiceType).streamServiceSettings(streamServiceSettings).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String streamServiceType;

    @NonNull
    private JsonObject streamServiceSettings;
  }
}
