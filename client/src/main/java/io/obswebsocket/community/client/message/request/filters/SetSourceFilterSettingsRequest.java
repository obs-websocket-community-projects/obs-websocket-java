// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.filters;

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
public class SetSourceFilterSettingsRequest extends Request<SetSourceFilterSettingsRequest.SpecificData> {
  @Builder
  private SetSourceFilterSettingsRequest(String sourceName, String filterName,
      JsonObject filterSettings, Boolean overlay) {
    super(RequestType.SetSourceFilterSettings, SpecificData.builder().sourceName(sourceName).filterName(filterName).filterSettings(filterSettings).overlay(overlay).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String sourceName;

    @NonNull
    private String filterName;

    @NonNull
    private JsonObject filterSettings;

    private Boolean overlay;
  }
}
