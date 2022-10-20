// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.inputs;

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
public class GetInputDefaultSettingsResponse extends RequestResponse<GetInputDefaultSettingsResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Object of default settings for the input kind
     */
    @NonNull
    private JsonObject defaultInputSettings;
  }
}
