package net.twasi.obsremotejava.message.event.sceneitems;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.event.Event;

@Getter
@ToString(callSuper = true)
abstract class SceneItemEvent extends Event {
    protected SceneItemEvent(Type eventType, Category category) {
        super(eventType, category);
    }

    @Getter
    @ToString
    protected static class Data {
        private String sceneName;
    }
}
