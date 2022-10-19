package io.obswebsocket.community.client.message.request.general;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class TriggerHotkeyByKeySequenceRequest extends Request<TriggerHotkeyByKeySequenceRequest.Data> {
  @Builder
  private TriggerHotkeyByKeySequenceRequest(String keyId, KeyModifiers keyModifiers) {
    super(RequestType.TriggerHotkeyByKeySequence,
        Data.builder().keyId(keyId).keyModifiers(keyModifiers).build());
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    private final String keyId;
    private final KeyModifiers keyModifiers;
  }

  @Builder
  public static class KeyModifiers {

    private final boolean shift;
    private final boolean alt;
    private final boolean control;
    private final boolean command;
  }
}
