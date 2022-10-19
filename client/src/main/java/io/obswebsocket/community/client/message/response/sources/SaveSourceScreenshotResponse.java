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
public class SaveSourceScreenshotResponse extends
    RequestResponse<SaveSourceScreenshotResponse.SpecificData> {

  @Getter
  @ToString
  @Builder
  public static class SpecificData {

    /**
     * Base64-encoded screenshot
     */
    @NonNull
    private String imageData;
  }
}
