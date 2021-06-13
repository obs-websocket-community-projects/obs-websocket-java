package net.twasi.obsremotejava.message.event.inputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputVolumeChanged extends Input {
    private Data eventData;

    protected InputVolumeChanged() {
        super(Type.InputVolumeChanged, Category.Inputs);
    }

    @Getter
    @ToString(callSuper = true)
    public static class Data extends Input.Data {
        private float inputVolumeMul;
        private float inputVolumeDb;
    }
}
