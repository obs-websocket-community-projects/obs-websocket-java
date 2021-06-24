package io.obswebsocket.community.message.event.config;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.event.Event;

@Getter
@ToString(callSuper = true)
public class CurrentProfileChangedEvent extends Event {
    private Data eventData;

    protected CurrentProfileChangedEvent() {
        super(Type.CurrentProfileChanged, Category.Config);
    }

    @Getter
    @ToString
    public static class Data {
        private String currentProfileName;
    }
}
