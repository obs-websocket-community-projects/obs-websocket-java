package net.twasi.obsremotejava.message.event.inputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputNameChanged extends Input {
    private Data eventData;

    protected InputNameChanged() {
        super(Type.InputNameChanged, Category.Inputs);
    }

    @Getter
    @ToString(callSuper = true)
    public static class Data extends Input.Data {
        private String oldInputName;
    }
}
