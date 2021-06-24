package io.obswebsocket.community.message.event.config;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.event.Event;
import io.obswebsocket.community.model.Profile;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class ProfileListChangedEvent extends Event {
    private Data eventData;

    protected ProfileListChangedEvent() {
        super(Type.ProfileListChanged, Category.Config);
    }

    @Getter
    @ToString
    public static class Data {
        private List<Profile> profiles;
    }
}
