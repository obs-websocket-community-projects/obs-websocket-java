package io.obswebsocket.community.client.message.response.inputs;

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
public class ToggleInputMuteResponse extends RequestResponse<ToggleInputMuteResponse.SpecificData> {

  @Getter
  @ToString
  @Builder
  public static class SpecificData {

    /**
     * Whether the input has been muted or unmuted
     */
    @NonNull
    private Boolean inputMuted;
  }
}
