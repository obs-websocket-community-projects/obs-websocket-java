package net.twasi.obsremotejava.message.event.scenes;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.event.Event;

@Getter
@ToString
public class CurrentPreviewSceneChanged extends Event {
    private Data eventData;

    protected CurrentPreviewSceneChanged() {
        super(Type.CurrentPreviewSceneChanged, Category.Scenes);
    }

    @Getter
    @ToString
    public static class Data {
        private String sceneName;
    }
}
