package io.obswebsocket.community.message.event.scenes;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.event.Event;
import io.obswebsocket.community.model.Scene;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class SceneListChangedEvent extends Event {
    private Data eventData;

    protected SceneListChangedEvent() {
        super(Type.SceneListChanged, Category.Scenes);
    }

    @Getter
    @ToString
    public static class Data {
        private List<Scene> scenes;
    }
}
