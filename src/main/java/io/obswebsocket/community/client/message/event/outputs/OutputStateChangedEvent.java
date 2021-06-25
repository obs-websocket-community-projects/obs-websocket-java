package io.obswebsocket.community.client.message.event.outputs;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.event.Event;

@Getter
@ToString
abstract class OutputStateChangedEvent extends Event {
    protected OutputStateChangedEvent(Type eventType, Category category) {
        super(eventType, category);
    }

    @Getter
    @ToString
    protected static class Data {
        private Boolean outputActive;
        private String outputState;
    }
}
