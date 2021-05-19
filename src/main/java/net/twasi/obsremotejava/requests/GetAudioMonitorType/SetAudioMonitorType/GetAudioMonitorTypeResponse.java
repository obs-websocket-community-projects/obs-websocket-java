package net.twasi.obsremotejava.requests.GetAudioMonitorType.SetAudioMonitorType;

import net.twasi.obsremotejava.requests.ResponseBase;

public class GetAudioMonitorTypeResponse extends ResponseBase {
    public static final String MONITOR_TYPE_NONE = "none";
    public static final String MONITOR_TYPE_MONITOR_ONLY = "monitorOnly";
    public static final String MONITOR_TYPE_MONITOR_AND_OUTPUT = "monitorAndOutput";

    private String monitorType;

    public String getMonitorType() {
        return this.monitorType;
    }
}
