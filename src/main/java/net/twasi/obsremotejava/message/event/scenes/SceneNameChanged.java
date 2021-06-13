package net.twasi.obsremotejava.message.event.scenes;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneNameChanged extends SceneChanged {
    private Data eventData;

    protected SceneNameChanged() {
        super(Type.SceneNameChanged, Category.Scenes);
    }

    @Getter
    @ToString(callSuper = true)
    public static class Data extends SceneChanged.Data {
        private String oldSceneName;
    }
}
