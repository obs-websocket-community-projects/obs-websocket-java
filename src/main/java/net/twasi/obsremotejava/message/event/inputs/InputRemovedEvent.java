package net.twasi.obsremotejava.message.event.inputs;

import lombok.ToString;

@ToString(callSuper = true)
public class InputRemovedEvent extends InputEvent {
    protected InputRemovedEvent() {
        super(Type.InputRemoved, Category.Inputs);
    }
}
