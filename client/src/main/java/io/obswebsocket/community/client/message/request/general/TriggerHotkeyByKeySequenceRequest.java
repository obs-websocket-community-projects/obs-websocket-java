package io.obswebsocket.community.client.message.request.general;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import io.obswebsocket.community.client.model.KeyModifiers;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class TriggerHotkeyByKeySequenceRequest extends Request<TriggerHotkeyByKeySequenceRequest.SpecificData> {
  @Builder
  private TriggerHotkeyByKeySequenceRequest(String keyId, KeyModifiers keyModifiers) {
    super(RequestType.TriggerHotkeyByKeySequence, SpecificData.builder().keyId(keyId).keyModifiers(keyModifiers).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    private String keyId;

    private KeyModifiers keyModifiers;
  }
}
