package io.obswebsocket.community.client.message.response.config;

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
public class GetRecordDirectoryResponse extends RequestResponse<GetRecordDirectoryResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Output directory
     */
    @NonNull
    private String recordDirectory;
  }
}
