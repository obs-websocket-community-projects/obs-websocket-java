package io.obswebsocket.community.client.message.response.ui;

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
public class GetStudioModeEnabledResponse extends RequestResponse<GetStudioModeEnabledResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Whether studio mode is enabled
     */
    @NonNull
    private Boolean studioModeEnabled;
  }
}
