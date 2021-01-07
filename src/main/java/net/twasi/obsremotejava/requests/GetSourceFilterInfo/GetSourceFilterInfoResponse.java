package net.twasi.obsremotejava.requests.GetSourceFilterInfo;

import net.twasi.obsremotejava.objects.SourceFilterInfo;
import net.twasi.obsremotejava.requests.ResponseBase;

import java.util.Map;

public class GetSourceFilterInfoResponse extends ResponseBase {
    private boolean filterStatus; // whether the filter is visible or not
    private String type;
    private String name;
    private Map<String, String> settings;

    public boolean isFilterVisible() {
        return filterStatus;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getSettings() {
        return settings;
    }
}
