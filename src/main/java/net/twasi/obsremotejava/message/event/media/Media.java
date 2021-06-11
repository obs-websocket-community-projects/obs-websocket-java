package net.twasi.obsremotejava.message.event.media;

import net.twasi.obsremotejava.message.event.Event;

public abstract class Media extends Event {
    private Data eventData;

    protected Media(Type eventType) {
        super(eventType);
    }

    public Data getEventData() {
        return this.eventData;
    }

    public static class Data {
        private String sourceName;
        private String sourceKind;

        public String getSourceName() {
            return sourceName;
        }

        public String getSourceKind() {
            return sourceKind;
        }
    }
}
