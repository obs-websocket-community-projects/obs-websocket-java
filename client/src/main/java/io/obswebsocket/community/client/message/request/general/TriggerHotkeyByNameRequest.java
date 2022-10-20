// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.general;

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
public class TriggerHotkeyByNameRequest extends Request<TriggerHotkeyByNameRequest.SpecificData> {
  @Builder
  private TriggerHotkeyByNameRequest(String hotkeyName) {
    super(RequestType.TriggerHotkeyByName, SpecificData.builder().hotkeyName(hotkeyName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String hotkeyName;
  }
}
