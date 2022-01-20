package io.obswebsocket.community.client.message.request.general;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class TriggerHotkeyByNameRequest extends Request {

  private final Data requestData;

  @Builder
  private TriggerHotkeyByNameRequest(String hotkeyName) {
    super(Request.Data.Type.TriggerHotkeyByName);

    this.requestData = Data.builder().hotkeyName(hotkeyName).build();
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    @NonNull
    private final String hotkeyName;
  }
}
