package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetProfileParameterRequest extends Request<GetProfileParameterRequest.SpecificData> {
  @Builder
  private GetProfileParameterRequest(String parameterCategory, String parameterName) {
    super(Request.Data.Type.GetProfileParameter, SpecificData.builder().parameterCategory(parameterCategory).parameterName(parameterName)
                                                             .build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {

    @NonNull
    private final String parameterCategory;
    @NonNull
    private final String parameterName;
  }
}
