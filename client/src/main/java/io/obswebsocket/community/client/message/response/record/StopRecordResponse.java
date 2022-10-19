package io.obswebsocket.community.client.message.response.record;

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
public class StopRecordResponse extends RequestResponse<StopRecordResponse.SpecificData> {

  @Getter
  @ToString
  @Builder
  public static class SpecificData {

    /**
     * File name for the saved recording
     */
    @NonNull
    private String outputPath;
  }
}
