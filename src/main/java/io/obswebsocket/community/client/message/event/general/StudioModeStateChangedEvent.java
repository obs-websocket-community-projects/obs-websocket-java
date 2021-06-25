package io.obswebsocket.community.client.message.event.general;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.event.Event;

@Getter
@ToString(callSuper = true)
public class StudioModeStateChangedEvent extends Event {
    private Data eventData;

    protected StudioModeStateChangedEvent() {
        super(Type.StudioModeStateChanged, Category.General);
    }

    @Getter
    @ToString
    public static class Data {
        private Boolean studioModeEnabled;
    }
}
