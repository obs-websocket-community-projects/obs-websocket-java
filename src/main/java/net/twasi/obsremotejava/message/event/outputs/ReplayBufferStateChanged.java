package net.twasi.obsremotejava.message.event.outputs;

import lombok.ToString;

@ToString
public class ReplayBufferStateChanged extends OutputStateChanged {
    protected ReplayBufferStateChanged() {
        super(Type.ReplayBufferStateChanged, Category.Outputs);
    }
}
