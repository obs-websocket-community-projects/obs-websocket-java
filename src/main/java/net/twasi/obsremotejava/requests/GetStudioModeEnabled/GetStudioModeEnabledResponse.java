package net.twasi.obsremotejava.requests.GetStudioModeEnabled;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.requests.ResponseBase;

public class GetStudioModeEnabledResponse extends ResponseBase {
    @SerializedName("studio-mode")
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }
}
