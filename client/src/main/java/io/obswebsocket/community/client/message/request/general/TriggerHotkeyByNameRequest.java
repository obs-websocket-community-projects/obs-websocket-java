package io.obswebsocket.community.client.message.request.general;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class TriggerHotkeyByNameRequest extends Request<TriggerHotkeyByNameRequest.Data> {
  @Builder
  private TriggerHotkeyByNameRequest(String hotkeyName) {
    super(RequestType.TriggerHotkeyByName, Data.builder().hotkeyName(hotkeyName).build());
  }

  @Getter
  @ToString
  @Builder
  static class Data {
    @NonNull
    private final String hotkeyName;
  }
}
