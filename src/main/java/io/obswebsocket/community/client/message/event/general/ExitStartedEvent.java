package io.obswebsocket.community.client.message.event.general;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.event.Event;

@Getter
@ToString(callSuper = true)
public class ExitStartedEvent extends Event {
    protected ExitStartedEvent() {
        super(Type.ExitStarted, Category.General);
    }
}
