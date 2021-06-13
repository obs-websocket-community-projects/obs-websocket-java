package net.twasi.obsremotejava.message.event.outputs;

import lombok.ToString;

@ToString(callSuper = true)
public class StreamStateChanged extends OutputStateChanged {
    protected StreamStateChanged() {
        super(Type.StreamStateChanged, Category.Outputs);
    }
}
