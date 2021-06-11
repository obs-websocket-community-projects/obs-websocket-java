package net.twasi.obsremotejava.message;

public abstract class EventBase extends MessageBase {
    protected EventType eventType;

    protected EventBase(EventType eventType) {
        super(Type.Event);
    }

    public EventType getEventType() {
        return this.eventType;
    }
}
