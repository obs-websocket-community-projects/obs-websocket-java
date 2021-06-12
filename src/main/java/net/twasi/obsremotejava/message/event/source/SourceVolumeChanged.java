package net.twasi.obsremotejava.message.event.source;

import net.twasi.obsremotejava.message.event.Event;

public class SourceVolumeChanged extends Source {
    private Data eventData;

    protected SourceVolumeChanged() {
        super(Type.SourceVolumeChanged);
    }

    @Override
    public Data getEventData() {
        return this.eventData;
    }

    public static class Data extends Source.Data {
        private float volume;
        private float volumeDb;

        public float getVolume() {
            return this.volume;
        }

        public float getVolumeDb() {
            return this.volumeDb;
        }
    }
}
