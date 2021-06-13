package net.twasi.obsremotejava.message.event.general;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.event.Event;

@Getter
@ToString(callSuper = true)
public class ExitStarted extends Event {
    protected ExitStarted() {
        super(Type.ExitStarted, Category.General);
    }
}
