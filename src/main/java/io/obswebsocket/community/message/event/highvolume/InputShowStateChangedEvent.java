package io.obswebsocket.community.message.event.highvolume;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class InputShowStateChangedEvent extends InputStateChangedEvent {
    private Data eventData;

    protected InputShowStateChangedEvent() {
        super(Type.InputShowStateChanged, Category.InputShowStateChanged);
    }

    @Getter
    @ToString(callSuper = true)
    public static class Data extends InputStateChangedEvent.Data {
        private Boolean videoShowing;
    }
}
