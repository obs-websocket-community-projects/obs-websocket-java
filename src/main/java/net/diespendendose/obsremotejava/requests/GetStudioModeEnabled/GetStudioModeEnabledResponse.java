package net.diespendendose.obsremotejava.requests.GetStudioModeEnabled;

import com.google.gson.annotations.SerializedName;
import net.diespendendose.obsremotejava.requests.ResponseBase;

public class GetStudioModeEnabledResponse extends ResponseBase {
    @SerializedName("studio-mode")
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }
}
