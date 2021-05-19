package net.twasi.obsremotejava.requests.GetSourceFilterInfo;

import com.google.gson.JsonObject;
import net.twasi.obsremotejava.requests.ResponseBase;

import java.util.Map;

public class GetSourceFilterInfoResponse extends ResponseBase {
    private boolean enabled;
    private String type;
    private String name;
    private Map<String, String> settings;

    public boolean isEnabled() {
        return enabled;
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
