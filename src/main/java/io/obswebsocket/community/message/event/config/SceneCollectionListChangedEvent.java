package io.obswebsocket.community.message.event.config;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.event.Event;
import io.obswebsocket.community.model.SceneCollection;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class SceneCollectionListChangedEvent extends Event {
    private Data eventData;

    protected SceneCollectionListChangedEvent() {
        super(Type.SceneCollectionListChanged, Category.Config);
    }

    @Getter
    @ToString
    public static class Data {
        private List<SceneCollection> sceneCollections;
    }
}
