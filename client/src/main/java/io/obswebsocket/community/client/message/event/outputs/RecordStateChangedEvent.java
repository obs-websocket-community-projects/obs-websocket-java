package io.obswebsocket.community.client.message.event.outputs;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class RecordStateChangedEvent extends OutputStateChangedEvent<RecordStateChangedEvent.SpecificData> {
  protected RecordStateChangedEvent() {
    super(Intent.Outputs);
  }

  protected RecordStateChangedEvent(SpecificData specificData) {
    super(Intent.Outputs, specificData);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class SpecificData extends OutputStateChangedEvent.SpecificData {
    private String outputPath;
  }
}
