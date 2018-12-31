package net.twasi.obsremotejava.requests.GetVolume;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class GetVolumeRequest extends BaseRequest {
    private String source;

    public GetVolumeRequest(OBSCommunicator com, String name) {
        super(RequestType.GetVolume);

        this.source = name;

        com.messageTypes.put(getMessageId(), GetVolumeResponse.class);
    }
}
