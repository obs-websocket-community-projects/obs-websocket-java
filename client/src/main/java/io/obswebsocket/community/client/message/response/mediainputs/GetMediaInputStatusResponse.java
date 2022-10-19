package io.obswebsocket.community.client.message.response.mediainputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.MediaState;
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
public class GetMediaInputStatusResponse extends RequestResponse<GetMediaInputStatusResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * State of the media input
     */
    @NonNull
    private MediaState mediaState;

    /**
     * Total duration of the playing media in milliseconds. `null` if not playing
     */
    @NonNull
    private Number mediaDuration;

    /**
     * Position of the cursor in milliseconds. `null` if not playing
     */
    @NonNull
    private Number mediaCursor;
  }
}
