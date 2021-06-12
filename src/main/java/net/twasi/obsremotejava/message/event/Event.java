package net.twasi.obsremotejava.message.event;

import net.twasi.obsremotejava.message.Message;
import net.twasi.obsremotejava.message.event.general.RecordingStarted;

import java.util.HashMap;

public abstract class Event extends Message {
    protected Type eventType;

    protected Event(Type eventType) {
        super(Message.Type.Event);

        this.eventType = eventType;
    }

    public Type getEventType() {
        return this.eventType;
    }

    public enum Type {
        RecordingStarted(net.twasi.obsremotejava.message.event.general.RecordingStarted.class),
        RecordingStopped(net.twasi.obsremotejava.message.event.general.RecordingStopped.class),
        ReplayStarting(net.twasi.obsremotejava.message.event.general.ReplayStarting.class),
        ReplayStarted(net.twasi.obsremotejava.message.event.general.ReplayStarted.class),
        ReplayStopping(net.twasi.obsremotejava.message.event.general.ReplayStopping.class),
        ReplayStopped(net.twasi.obsremotejava.message.event.general.ReplayStopped.class),
        StreamStarted(net.twasi.obsremotejava.message.event.general.StreamStarted.class),
        StreamStopped(net.twasi.obsremotejava.message.event.general.StreamStopped.class),
        SwitchScenes(net.twasi.obsremotejava.message.event.scenes.SwitchScenes.class),
        ScenesChanged(net.twasi.obsremotejava.message.event.scenes.ScenesChanged.class),
        SourceFilterVisibilityChanged(net.twasi.obsremotejava.message.event.source.SourceFilterVisibilityChanged.class),
        SourceVolumeChanged(net.twasi.obsremotejava.message.event.source.SourceVolumeChanged.class),
        SwitchTransition(net.twasi.obsremotejava.message.event.transition.SwitchTransition.class),
        TransitionListChanged(net.twasi.obsremotejava.message.event.transition.TransitionListChanged.class),
        TransitionBegin(net.twasi.obsremotejava.message.event.transition.TransitionBegin.class),
        TransitionEnd(net.twasi.obsremotejava.message.event.transition.TransitionEnd.class),
        PreviewSceneChanged(net.twasi.obsremotejava.message.event.scene.PreviewSceneChanged.class),
        MediaPlaying(net.twasi.obsremotejava.message.event.media.MediaPlaying.class),
        MediaPaused(net.twasi.obsremotejava.message.event.media.MediaPaused.class),
        MediaRestarted(net.twasi.obsremotejava.message.event.media.MediaRestarted.class),
        MediaStopped(net.twasi.obsremotejava.message.event.media.MediaStopped.class),
        MediaNext(net.twasi.obsremotejava.message.event.media.MediaNext.class),
        MediaPrevious(net.twasi.obsremotejava.message.event.media.MediaPrevious.class),
        MediaStarted(net.twasi.obsremotejava.message.event.media.MediaStarted.class),
        MediaEnded(net.twasi.obsremotejava.message.event.media.MediaEnded.class);

        private final Class<? extends Event> clazz;

        Type(Class<? extends Event> clazz) {
            this.clazz = clazz;
        }

        public Class<? extends Event> getClazz() {
            return this.clazz;
        }
    }
}
