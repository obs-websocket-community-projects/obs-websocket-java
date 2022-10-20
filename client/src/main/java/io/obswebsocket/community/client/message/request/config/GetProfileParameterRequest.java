// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetProfileParameterRequest extends Request<GetProfileParameterRequest.SpecificData> {
  @Builder
  private GetProfileParameterRequest(String parameterCategory, String parameterName) {
    super(RequestType.GetProfileParameter, SpecificData.builder().parameterCategory(parameterCategory).parameterName(parameterName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String parameterCategory;

    @NonNull
    private String parameterName;
  }
}
