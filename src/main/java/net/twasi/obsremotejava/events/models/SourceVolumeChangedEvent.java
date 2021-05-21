package net.twasi.obsremotejava.events.models;

import net.twasi.obsremotejava.events.EventBase;

public class SourceVolumeChangedEvent extends EventBase {
    private String sourceName;
    private float volume;
    private float volumeDb;

    public String getSourceName() {
        return sourceName;
    }

    public float getVolume() {
        return volume;
    }

    public float getVolumeDb() {
        return volumeDb;
    }
}
