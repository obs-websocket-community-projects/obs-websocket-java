package net.diespendendose.obsremotejava.requests.GetVolume;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class GetVolumeRequest extends BaseRequest {
    private String source;

    public GetVolumeRequest(OBSCommunicator com, String name) {
        super(RequestType.GetVolume);

        this.source = name;

        com.messageTypes.put(getMessageId(), GetVolumeResponse.class);
    }
}
