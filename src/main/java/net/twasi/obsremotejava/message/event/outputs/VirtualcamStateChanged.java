package net.twasi.obsremotejava.message.event.outputs;

import lombok.ToString;

@ToString(callSuper = true)
public class VirtualcamStateChanged extends OutputStateChanged {
    protected VirtualcamStateChanged() {
        super(Type.VirtualcamStateChanged, Category.Outputs);
    }
}
