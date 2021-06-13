package net.twasi.obsremotejava.message.event.sceneitems;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public abstract class SceneItemSource extends SceneItem {
    private Data eventData;

    protected SceneItemSource(Type eventType, Category category) {
        super(eventType, category);
    }

    @Getter
    @ToString(callSuper = true)
    public static class Data extends SceneItem.Data {
        private String sourceName;
        private String sourceItemId;
    }
}
