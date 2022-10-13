package io.obswebsocket.community.client.message.event.outputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RecordStateChangedEvent extends OutputStateChangedEvent {
  protected RecordStateChangedEvent() {
    super(Intent.Outputs);
  }
}
