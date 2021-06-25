package io.obswebsocket.community.client.message.event.scenes;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.event.Event;

@Getter
@ToString(callSuper = true)
abstract class SceneChangedEvent extends Event {
    protected SceneChangedEvent(Type eventType, Category category) {
        super(eventType, category);
    }

    @Getter
    @ToString
    protected static class Data {
        private String sceneName;
    }
}
