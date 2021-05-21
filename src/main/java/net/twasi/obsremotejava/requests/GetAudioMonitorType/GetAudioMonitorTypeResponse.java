package net.twasi.obsremotejava.requests.GetAudioMonitorType;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.requests.ResponseBase;

public class GetAudioMonitorTypeResponse extends ResponseBase {
    public enum MonitorType {
        @SerializedName("none")
        NONE,
        @SerializedName("monitorOnly")
        MONITOR_ONLY,
        @SerializedName("monitorAndOutput")
        MONITOR_AND_OUTPUT
    }

    private MonitorType monitorType;

    public MonitorType getMonitorType() {
        return this.monitorType;
    }
}
