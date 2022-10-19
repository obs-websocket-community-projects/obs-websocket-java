package io.obswebsocket.community.client.message.request.filters;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class GetSourceFilterDefaultSettingsRequest extends Request<GetSourceFilterDefaultSettingsRequest.SpecificData> {
  @Builder
  private GetSourceFilterDefaultSettingsRequest(String filterKind) {
    super(RequestType.GetSourceFilterDefaultSettings, SpecificData.builder().filterKind(filterKind).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String filterKind;
  }
}
