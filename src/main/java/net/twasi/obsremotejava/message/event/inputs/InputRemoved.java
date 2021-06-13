package net.twasi.obsremotejava.message.event.inputs;

import lombok.ToString;

@ToString(callSuper = true)
public class InputRemoved extends Input {
    protected InputRemoved() {
        super(Type.InputRemoved, Category.Inputs);
    }
}
