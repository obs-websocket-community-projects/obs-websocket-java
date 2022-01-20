package io.obswebsocket.community.client.message.request.filters;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class RemoveSourceFilterRequest extends FilterRequest {

  private final Data requestData;

  @Builder
  private RemoveSourceFilterRequest(String sourceName, String filterName) {
    super(Request.Data.Type.RemoveSourceFilter);

    this.requestData = Data.builder().sourceName(sourceName).filterName(filterName).build();
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends FilterRequest.Data {

    @NonNull
    private final String filterName;
  }
}
