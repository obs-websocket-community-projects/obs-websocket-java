package net.twasi.obsremotejava.objects;

import java.util.Map;

public class SourceFilterInfo {

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
