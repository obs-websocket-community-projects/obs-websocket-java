package net.twasi.obsremotejava.message.event.source;

import net.twasi.obsremotejava.message.event.Event;

public abstract class Source extends Event {
    private Data eventData;

    protected Source(Event.Type eventType) {
        super(eventType);
    }

    public Data getEventData() {
        return this.eventData;
    }

    public static class Data {
        private String sourceName;

        public String getSourceName() {
            return sourceName;
        }
    }
}
