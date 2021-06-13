package net.twasi.obsremotejava.message.event.general;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.event.Event;

@Getter
@ToString(callSuper = true)
public class ExitStartedEvent extends Event {
    protected ExitStartedEvent() {
        super(Type.ExitStarted, Category.General);
    }
}
