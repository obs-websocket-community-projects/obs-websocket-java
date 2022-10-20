// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.filters;

import com.google.gson.JsonObject;
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
public class CreateSourceFilterRequest extends Request<CreateSourceFilterRequest.SpecificData> {
  @Builder
  private CreateSourceFilterRequest(String sourceName, String filterName, String filterKind,
      JsonObject filterSettings) {
    super(RequestType.CreateSourceFilter, SpecificData.builder().sourceName(sourceName).filterName(filterName).filterKind(filterKind).filterSettings(filterSettings).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String sourceName;

    @NonNull
    private String filterName;

    @NonNull
    private String filterKind;

    private JsonObject filterSettings;
  }
}
