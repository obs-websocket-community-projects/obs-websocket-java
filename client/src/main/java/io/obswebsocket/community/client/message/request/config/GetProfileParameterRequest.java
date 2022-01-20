package io.obswebsocket.community.client.message.request.config;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetProfileParameterRequest extends Request {

  @SerializedName("d")
  private final Data data;

  @Builder
  private GetProfileParameterRequest(String parameterCategory, String parameterName) {
    super(Request.Data.Type.GetProfileParameter);

    this.data = Data.builder().requestId(this.getRequestId()).requestType(this.getRequestType())
        .requestData(
            SpecificData.builder().parameterCategory(parameterCategory).parameterName(parameterName)
                .build()).build();
  }

  @SuperBuilder
  @Getter
  @ToString
  static class Data extends Request.Data {

    private SpecificData requestData;
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
