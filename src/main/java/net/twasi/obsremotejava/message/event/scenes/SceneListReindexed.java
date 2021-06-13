package net.twasi.obsremotejava.message.event.scenes;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.event.Event;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class SceneListReindexed extends Event {
    private Data eventData;

    protected SceneListReindexed() {
        super(Type.SceneListReindexed, Category.Scenes);
    }

    @Getter
    @ToString
    public static class Data {
        private List<Scene> scenes;

        @Getter
        @ToString
        public static class Scene {
            private String sceneName;
            private Integer sceneIndex;
        }
    }
}
