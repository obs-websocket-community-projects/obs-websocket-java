package io.obswebsocket.community.client.message.event.highvolume;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputActiveStateChangedEvent extends InputStateChangedEvent {
    private Data eventData;

    protected InputActiveStateChangedEvent() {
        super(Type.InputActiveStateChanged, Category.InputActiveStateChanged);
    }

    @Getter
    @ToString(callSuper = true)
    public static class Data extends InputStateChangedEvent.Data {
        private Boolean videoActive;
    }
}
