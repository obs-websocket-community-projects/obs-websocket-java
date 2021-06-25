package io.obswebsocket.community.client.message.event.inputs;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.event.Event;

@Getter
@ToString
abstract class InputEvent extends Event {
    protected InputEvent(Event.Type eventType, Category category) {
        super(eventType, category);
    }

    @Getter
    @ToString
    protected static class Data {
        private String inputName;
    }
}
