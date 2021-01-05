package net.twasi.obsremotejava.events.responses;

import net.twasi.obsremotejava.requests.ResponseBase;

public class SourceFilterVisibilityChangedResponse extends ResponseBase {
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
