package net.twasi.obsremotejava.message.event.outputs;

import lombok.ToString;

@ToString(callSuper = true)
public class ReplayBufferStateChanged extends OutputStateChanged {
    protected ReplayBufferStateChanged() {
        super(Type.ReplayBufferStateChanged, Category.Outputs);
    }
}
