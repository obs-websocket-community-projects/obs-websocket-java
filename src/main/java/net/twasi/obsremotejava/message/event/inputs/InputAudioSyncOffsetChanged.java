package net.twasi.obsremotejava.message.event.inputs;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.event.Event;

@Getter
@ToString(callSuper = true)
public class InputAudioSyncOffsetChanged extends Event {
    private Data eventData;

    protected InputAudioSyncOffsetChanged() {
        super(Type.InputAudioSyncOffsetChanged, Category.Inputs);
    }

    @Getter
    @ToString
    public static class Data {
        private Long inputAudioSyncOffset;
    }
}
