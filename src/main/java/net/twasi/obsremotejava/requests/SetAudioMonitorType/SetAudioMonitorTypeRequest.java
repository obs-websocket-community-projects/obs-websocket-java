package net.twasi.obsremotejava.requests.SetAudioMonitorType;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.RequestBase;
import net.twasi.obsremotejava.requests.GetAudioMonitorType.GetAudioMonitorTypeResponse;
import net.twasi.obsremotejava.requests.RequestType;

public class SetAudioMonitorTypeRequest extends RequestBase {
    private String sourceName;
    private GetAudioMonitorTypeResponse.MonitorType monitorType;

    public SetAudioMonitorTypeRequest(OBSCommunicator com, String sourceName, GetAudioMonitorTypeResponse.MonitorType monitorType) {
        super(RequestType.SetAudioMonitorType);

        this.monitorType = monitorType;
        this.sourceName = sourceName;

        com.messageTypes.put(getMessageId(), SetAudioMonitorTypeResponse.class);
    }
}
