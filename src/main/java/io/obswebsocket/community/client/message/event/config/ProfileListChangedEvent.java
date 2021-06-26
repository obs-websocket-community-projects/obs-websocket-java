package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.Profile;
import lombok.Getter;
import lombok.ToString;

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
