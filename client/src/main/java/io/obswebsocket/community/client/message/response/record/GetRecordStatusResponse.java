// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.record;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetRecordStatusResponse extends RequestResponse<GetRecordStatusResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Whether the output is active
     */
    @NonNull
    private Boolean outputActive;

    /**
     * Whether the output is paused
     */
    @NonNull
    private Boolean outputPaused;

    /**
     * Current formatted timecode string for the output
     */
    @NonNull
    private String outputTimecode;

    /**
     * Current duration in milliseconds for the output
     */
    @NonNull
    private Number outputDuration;

    /**
     * Number of bytes sent by the output
     */
    @NonNull
    private Number outputBytes;
  }
}
