package net.diespendendose.obsremotejava.requests.GetVersion;

import com.google.gson.annotations.SerializedName;
import net.diespendendose.obsremotejava.requests.ResponseBase;

public class GetVersionResponse extends ResponseBase {
    @SerializedName("obs-websocket-version")
    private String obsWebsocketVersion;
    @SerializedName("obs-studio-version")
    private String obsStudioVersion;

    public String getObsWebsocketVersion() {
        return obsWebsocketVersion;
    }

    public String getObsStudioVersion() {
        return obsStudioVersion;
    }
}
