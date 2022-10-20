// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetInputAudioSyncOffsetResponse extends RequestResponse<GetInputAudioSyncOffsetResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Audio sync offset in milliseconds
     */
    @NonNull
    private Number inputAudioSyncOffset;
  }
}
