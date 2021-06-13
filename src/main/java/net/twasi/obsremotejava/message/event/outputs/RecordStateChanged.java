package net.twasi.obsremotejava.message.event.outputs;

import lombok.ToString;

@ToString(callSuper = true)
public class RecordStateChanged extends OutputStateChanged {
    protected RecordStateChanged() {
        super(Type.RecordStateChanged, Category.Outputs);
    }
}
