package io.obswebsocket.community.client.message.request.general;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class TriggerHotkeyByNameRequest extends Request<TriggerHotkeyByNameRequest.Data> {
  @Builder
  private TriggerHotkeyByNameRequest(String hotkeyName) {
    super(Request.Data.Type.TriggerHotkeyByName, Data.builder().hotkeyName(hotkeyName).build());
  }

  @Getter
  @ToString
  @Builder
  static class Data {
    @NonNull
    private final String hotkeyName;
  }
}
