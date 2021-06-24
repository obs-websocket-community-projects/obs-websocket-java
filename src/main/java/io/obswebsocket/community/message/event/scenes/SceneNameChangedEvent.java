package io.obswebsocket.community.message.event.scenes;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneNameChangedEvent extends SceneChangedEvent {
    private Data eventData;

    protected SceneNameChangedEvent() {
        super(Type.SceneNameChanged, Category.Scenes);
    }

    @Getter
    @ToString(callSuper = true)
    public static class Data extends SceneChangedEvent.Data {
        private String oldSceneName;
    }
}
