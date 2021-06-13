package net.twasi.obsremotejava.message.event.config;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.event.Event;
import net.twasi.obsremotejava.model.Profile;

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
