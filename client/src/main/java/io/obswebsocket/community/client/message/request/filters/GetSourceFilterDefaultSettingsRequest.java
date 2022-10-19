package io.obswebsocket.community.client.message.request.filters;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.filters.GetSourceFilterDefaultSettingsRequest.Data;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetSourceFilterDefaultSettingsRequest extends Request<Data> {
  @Builder
  private GetSourceFilterDefaultSettingsRequest(String filterKind) {
    super(Request.Data.Type.GetSourceFilterDefaultSettings, Data.builder().filterKind(filterKind).build());
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data {

    @NonNull
    private final String filterKind;
  }
}
