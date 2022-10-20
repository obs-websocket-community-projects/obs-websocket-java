// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.config;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetProfileParameterResponse extends RequestResponse<GetProfileParameterResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Value associated with the parameter. `null` if not set and no default
     */
    @NonNull
    private String parameterValue;

    /**
     * Default value associated with the parameter. `null` if no default
     */
    @NonNull
    private String defaultParameterValue;
  }
}
