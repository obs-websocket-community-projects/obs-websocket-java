package io.obswebsocket.community.message.event.inputs;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputVolumeChangedEvent extends InputEvent {
    private Data eventData;

    protected InputVolumeChangedEvent() {
        super(Type.InputVolumeChanged, Category.Inputs);
    }

    @Getter
    @ToString(callSuper = true)
    public static class Data extends InputEvent.Data {
        private float inputVolumeMul;
        private float inputVolumeDb;
    }
}
