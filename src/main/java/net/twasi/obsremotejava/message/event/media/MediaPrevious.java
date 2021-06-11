package net.twasi.obsremotejava.message.event.media;

import net.twasi.obsremotejava.message.event.Event;

public class MediaPrevious extends Media {
    static {
        Event.registerEventType(Type.MediaPrevious, MediaPrevious.class);
    }

    protected MediaPrevious() {
        super(Type.MediaPrevious);
    }
}
