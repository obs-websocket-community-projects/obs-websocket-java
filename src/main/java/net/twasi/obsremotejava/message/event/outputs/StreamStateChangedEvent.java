package net.twasi.obsremotejava.message.event.outputs;

import lombok.ToString;

@ToString(callSuper = true)
public class StreamStateChangedEvent extends OutputStateChangedEvent {
    protected StreamStateChangedEvent() {
        super(Type.StreamStateChanged, Category.Outputs);
    }
}
