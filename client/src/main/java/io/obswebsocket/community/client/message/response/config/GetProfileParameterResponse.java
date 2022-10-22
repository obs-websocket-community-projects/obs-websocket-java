// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.config;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetProfileParameterResponse extends RequestResponse<GetProfileParameterResponse.SpecificData> {
  /**
   * Value associated with the parameter. `null` if not set and no default
   *
   * @return the parameterValue
   */
  public String getParameterValue() {
    return getMessageData().getResponseData().getParameterValue();
  }

  /**
   * Default value associated with the parameter. `null` if no default
   *
   * @return the defaultParameterValue
   */
  public String getDefaultParameterValue() {
    return getMessageData().getResponseData().getDefaultParameterValue();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Value associated with the parameter. `null` if not set and no default
     */
    private String parameterValue;

    /**
     * Default value associated with the parameter. `null` if no default
     */
    private String defaultParameterValue;
  }
}
