package net.twasi.obsremotejava.requests.SetAudioMonitorType;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class SetAudioMonitorTypeRequest extends BaseRequest {
    private String sourceName;
    private String monitorType;

    public SetAudioMonitorTypeRequest(OBSCommunicator com, String sourceName, String monitorType) {
        super(RequestType.SetAudioMonitorType);

        this.monitorType = monitorType;
        this.sourceName = sourceName;

        com.messageTypes.put(getMessageId(), SetAudioMonitorTypeResponse.class);
    }
}
