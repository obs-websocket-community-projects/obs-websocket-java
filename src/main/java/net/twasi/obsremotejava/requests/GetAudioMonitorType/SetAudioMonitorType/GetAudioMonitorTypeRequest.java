package net.twasi.obsremotejava.requests.GetAudioMonitorType.SetAudioMonitorType;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class GetAudioMonitorTypeRequest extends BaseRequest {
    private String sourceName;

    public GetAudioMonitorTypeRequest(OBSCommunicator com, String sourceName) {
        super(RequestType.GetAudioMonitorType);

        this.sourceName = sourceName;

        com.messageTypes.put(getMessageId(), GetAudioMonitorTypeResponse.class);
    }
}
