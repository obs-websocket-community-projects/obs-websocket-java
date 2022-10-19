package io.obswebsocket.community.client.message.response.outputs;

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
public class GetOutputStatusResponse extends RequestResponse<GetOutputStatusResponse.SpecificData> {
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
     * Whether the output is reconnecting
     */
    @NonNull
    private Boolean outputReconnecting;

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
     * Congestion of the output
     */
    @NonNull
    private Number outputCongestion;

    /**
     * Number of bytes sent by the output
     */
    @NonNull
    private Number outputBytes;

    /**
     * Number of frames skipped by the output's process
     */
    @NonNull
    private Number outputSkippedFrames;

    /**
     * Total number of frames delivered by the output's process
     */
    @NonNull
    private Number outputTotalFrames;
  }
}
