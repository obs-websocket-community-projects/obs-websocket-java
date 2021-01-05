package net.twasi.obsremotejava.requests.GetVersion;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.requests.ResponseBase;

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

    @Override
    public String toString() {
        return "GetVersionResponse{" +
                "obsWebsocketVersion='" + obsWebsocketVersion + '\'' +
                ", obsStudioVersion='" + obsStudioVersion + '\'' +
                '}';
    }
}
