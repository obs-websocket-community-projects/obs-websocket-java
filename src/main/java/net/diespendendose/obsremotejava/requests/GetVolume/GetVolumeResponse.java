package net.diespendendose.obsremotejava.requests.GetVolume;

import net.diespendendose.obsremotejava.requests.ResponseBase;

public class GetVolumeResponse extends ResponseBase {
    private String name;
    private double volume;
    private boolean muted;

    public String getName() {
        return name;
    }

    public double getVolume() {
        return volume;
    }

    public boolean isMuted() {
        return muted;
    }
}
