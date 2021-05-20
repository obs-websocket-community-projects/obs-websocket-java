package net.twasi.obsremotejava.events.responses;

import net.twasi.obsremotejava.requests.ResponseBase;

public class SourceVolumeChangedResponse extends ResponseBase {
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
