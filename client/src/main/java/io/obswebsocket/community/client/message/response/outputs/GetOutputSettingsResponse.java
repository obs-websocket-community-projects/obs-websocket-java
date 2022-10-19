package io.obswebsocket.community.client.message.response.outputs;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class GetOutputSettingsResponse extends RequestResponse<GetOutputSettingsResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Output settings
     */
    @NonNull
    private JsonObject outputSettings;
  }
}
