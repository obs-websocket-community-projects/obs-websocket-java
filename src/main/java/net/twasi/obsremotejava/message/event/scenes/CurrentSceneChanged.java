package net.twasi.obsremotejava.message.event.scenes;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.event.Event;

@Getter
@ToString
public class CurrentSceneChanged extends Event {
    private Data eventData;

    protected CurrentSceneChanged() {
        super(Type.CurrentSceneChanged, Category.Scenes);
    }

    @Getter
    @ToString
    public static class Data {
        private String sceneName;
    }
}
