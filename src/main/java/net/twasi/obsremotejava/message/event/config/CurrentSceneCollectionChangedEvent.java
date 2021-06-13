package net.twasi.obsremotejava.message.event.config;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.event.Event;

@Getter
@ToString(callSuper = true)
public class CurrentSceneCollectionChangedEvent extends Event {
    private Data eventData;

    protected CurrentSceneCollectionChangedEvent() {
        super(Type.CurrentSceneCollectionChanged, Category.Config);
    }

    @Getter
    @ToString
    public static class Data {
        private String currentSceneCollectionName;
    }
}
