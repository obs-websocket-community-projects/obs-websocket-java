package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.model.Input;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class InputAudioMonitorTypeChangedEvent extends
    InputEvent<InputAudioMonitorTypeChangedEvent.SpecificData> {

  protected InputAudioMonitorTypeChangedEvent() {
    super(Intent.Inputs);
  }

  protected InputAudioMonitorTypeChangedEvent(SpecificData data) {
    super(Intent.Inputs, data);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends InputEvent.SpecificData {

    private Input.MonitorType monitorType;
  }
}
