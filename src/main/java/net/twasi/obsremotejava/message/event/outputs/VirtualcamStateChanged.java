package net.twasi.obsremotejava.message.event.outputs;

public class VirtualcamStateChanged extends OutputStateChanged {
    protected VirtualcamStateChanged() {
        super(Type.VirtualcamStateChanged, Category.Outputs);
    }
}
