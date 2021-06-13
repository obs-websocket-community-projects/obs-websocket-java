package net.twasi.obsremotejava.events.models;

import net.twasi.obsremotejava.events.EventBase;

public class SourceFilterVisibilityChangedEvent extends EventBase {
    private String sourceName;
    private String filterName;
    private boolean filterEnabled;

    public String getSourceName() {
        return sourceName;
    }

    public String getFilterName() {
        return filterName;
    }

    public boolean isFilterEnabled() {
        return filterEnabled;
    }
}
