package io.obswebsocket.community.client.message.event.general;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ExitStartedEvent extends Event {
    protected ExitStartedEvent() {
        super(Type.ExitStarted, Category.General);
    }
}
