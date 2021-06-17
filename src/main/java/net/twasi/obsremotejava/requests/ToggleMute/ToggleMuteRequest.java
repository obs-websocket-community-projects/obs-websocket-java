package net.twasi.obsremotejava.requests.ToggleMute;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.RequestBase;
import net.twasi.obsremotejava.requests.RequestType;

public class ToggleMuteRequest extends RequestBase {
    private String source;

    public ToggleMuteRequest(OBSCommunicator com, String source) {
        super(RequestType.ToggleMute);

        this.source = source;

        // com.messageTypes.put(getMessageId(), ToggleMuteResponse.class);
    }
}
