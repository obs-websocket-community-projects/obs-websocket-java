package net.twasi.obsremotejava.events.models;

import net.twasi.obsremotejava.events.EventBase;

abstract class MediaEvent extends EventBase {
    private String sourceName;
    private String sourceKind;

    public String getSourceName() {
        return sourceName;
    }

    public String getSourceKind() {
        return sourceKind;
    }
}
