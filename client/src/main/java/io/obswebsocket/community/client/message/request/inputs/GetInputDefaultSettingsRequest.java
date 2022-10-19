package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputDefaultSettingsRequest extends Request<GetInputDefaultSettingsRequest.Data> {
  @Builder
  private GetInputDefaultSettingsRequest(String inputKind) {
    super(RequestType.GetInputDefaultSettings, Data.builder().inputKind(inputKind).build());
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    @NonNull
    private final String inputKind;
  }
}
