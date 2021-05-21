package net.twasi.obsremotejava.callbacks;

import net.twasi.obsremotejava.events.EventBase;

public interface EventCallback<EventType extends EventBase> {

    void run(EventType response);

}
