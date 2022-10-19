package io.obswebsocket.community.client.message.response.ui;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Monitor;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class GetMonitorListResponse extends RequestResponse<GetMonitorListResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * a list of detected monitors with some information
     */
    @NonNull
    @Singular
    private List<Monitor> monitors;
  }
}
