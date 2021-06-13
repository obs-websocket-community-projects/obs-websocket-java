package net.twasi.obsremotejava.message.event.scenes;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.event.Event;

@Getter
@ToString(callSuper = true)
public abstract class SceneChanged extends Event {
    private Data eventData;

    protected SceneChanged(Type eventType, Category category) {
        super(eventType, category);
    }

    @Getter
    @ToString
    public static class Data {
        private String sceneName;
    }
}
