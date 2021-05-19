package net.twasi.obsremotejava.requests.GetSourceFilterInfo;

import com.google.gson.JsonObject;
import net.twasi.obsremotejava.requests.ResponseBase;

public class GetSourceFilterInfoResponse extends ResponseBase {
    private boolean enabled;
    private String type;
    private String name;
    private JsonObject settings;

    public boolean isEnabled() {
        return enabled;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public JsonObject getSettings() {
        return settings;
    }
}
