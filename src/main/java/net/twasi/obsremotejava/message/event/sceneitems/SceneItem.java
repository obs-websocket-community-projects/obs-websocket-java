package net.twasi.obsremotejava.message.event.sceneitems;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.event.Event;

@Getter
@ToString(callSuper = true)
public abstract class SceneItem extends Event {
    private Data eventData;

    protected SceneItem(Type eventType, Category category) {
        super(eventType, category);
    }

    @Getter
    @ToString
    public static class Data {
        private String sceneName;
    }
}
