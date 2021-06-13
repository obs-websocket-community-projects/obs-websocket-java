package net.twasi.obsremotejava.message.event.sceneitems;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public abstract class SceneItemSourceEvent extends SceneItemEvent {
    private Data eventData;

    protected SceneItemSourceEvent(Type eventType, Category category) {
        super(eventType, category);
    }

    @Getter
    @ToString(callSuper = true)
    public static class Data extends SceneItemEvent.Data {
        private String sourceName;
        private String sourceItemId;
    }
}
