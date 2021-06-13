package net.twasi.obsremotejava.message.event.inputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputMuteStateChangedEvent extends InputEvent {
    private Data eventData;

    protected InputMuteStateChangedEvent() {
        super(Type.InputMuteStateChanged, Category.Inputs);
    }

    @Getter
    @ToString(callSuper = true)
    public static class Data extends InputEvent.Data {
        private Boolean inputMuted;
    }
}
