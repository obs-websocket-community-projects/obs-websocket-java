package io.obswebsocket.community.client.message.event.scenes;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.Scene;
import lombok.Getter;
import lombok.ToString;

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
