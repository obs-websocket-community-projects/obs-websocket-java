package io.obswebsocket.community.client.message.response.sources;

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
public class GetSourceActiveResponse extends RequestResponse<GetSourceActiveResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Whether the source is showing in Program
     */
    @NonNull
    private Boolean videoActive;

    /**
     * Whether the source is showing in the UI (Preview, Projector, Properties)
     */
    @NonNull
    private Boolean videoShowing;
  }
}
