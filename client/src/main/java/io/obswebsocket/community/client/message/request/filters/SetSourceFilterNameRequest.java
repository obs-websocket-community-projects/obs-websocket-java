package io.obswebsocket.community.client.message.request.filters;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetSourceFilterNameRequest extends FilterRequest<SetSourceFilterNameRequest.Data> {
  @Builder
  private SetSourceFilterNameRequest(String sourceName, String filterName, String newFilterName) {
    super(null, Data.builder().sourceName(sourceName).filterName(filterName)
        .newFilterName(newFilterName).build());
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends FilterRequest.Data {

    @NonNull
    private final String filterName;
    @NonNull
    private final String newFilterName;
  }
}
