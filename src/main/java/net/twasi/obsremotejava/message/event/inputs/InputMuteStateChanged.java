package net.twasi.obsremotejava.message.event.inputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputMuteStateChanged extends Input {
    private Data eventData;

    protected InputMuteStateChanged() {
        super(Type.InputMuteStateChanged, Category.Inputs);
    }

    @Getter
    @ToString(callSuper = true)
    public static class Data extends Input.Data {
        private Boolean inputMuted;
    }
}
