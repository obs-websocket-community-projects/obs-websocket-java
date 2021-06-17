package net.twasi.obsremotejava.requests.GetMute;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.RequestBase;
import net.twasi.obsremotejava.requests.RequestType;

public class GetMuteRequest extends RequestBase {
    private String source;

    public GetMuteRequest(OBSCommunicator com, String source) {
        super(RequestType.GetMute);

        this.source = source;

//        // com.messageTypes.put(getMessageId(), GetMuteResponse.class);
    }
}
