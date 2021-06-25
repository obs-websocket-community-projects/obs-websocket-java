package io.obswebsocket.community.client.message.event.highvolume;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.Input;
import lombok.Getter;
import lombok.ToString;

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
