package net.twasi.obsremotejava.message.event.input;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class InputVolumeChanged extends Source {
    private Data eventData;

    protected InputVolumeChanged() {
        super(Type.InputVolumeChanged, Category.Inputs);
    }

    @Getter
    @ToString
    public static class Data extends Source.Data {
        private float inputVolumeMul;
        private float inputVolumeDb;
    }
}
