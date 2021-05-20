package net.twasi.obsremotejava.events.responses;

import net.twasi.obsremotejava.requests.ResponseBase;

public abstract class MediaResponse extends ResponseBase {
    private String sourceName;
    private String sourceKind;

    public String getSourceName() {
        return sourceName;
    }

    public String getSourceKind() {
        return sourceKind;
    }
}
