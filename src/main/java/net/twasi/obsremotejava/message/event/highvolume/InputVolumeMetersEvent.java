package net.twasi.obsremotejava.message.event.highvolume;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.event.Event;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class InputVolumeMetersEvent extends Event {
    private Data eventData;

    protected InputVolumeMetersEvent() {
        super(Type.InputVolumeMeters, Category.InputVolumeMeters);
    }

    @Getter
    @ToString
    public static class Data {
        private List<Input> inputs;
    }

    @Getter
    @ToString
    static class Input {
        private String inputName;
        private Double inputVolumeDb;
        private Double inputVolumeMul;
    }
}
