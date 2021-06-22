package net.twasi.obsremotejava.message.event.highvolume;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.event.Event;
import net.twasi.obsremotejava.model.Input;

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
        private List<InputLevels> inputs;
    }

    @Getter
    @ToString(callSuper = true)
    static class InputLevels extends Input {
        private Double inputVolumeDb;
        private Double inputVolumeMul;
    }
}
