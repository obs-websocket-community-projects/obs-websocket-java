package net.twasi.obsremotejava.requests.GetSourceSettings;

import net.twasi.obsremotejava.requests.ResponseBase;

import java.util.Map;

public class GetSourceSettingsResponse extends ResponseBase {
    private String sourceName;
    private String sourceType;
    private Map<String, Object> sourceSettings;

    public String getSourceName() {
        return sourceName;
    }

    public String getSourceType() {
        return sourceType;
    }

    public Map<String, Object> getSourceSettings() {
        return sourceSettings;
    }
}
