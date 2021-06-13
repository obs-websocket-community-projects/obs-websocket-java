package net.twasi.obsremotejava.requests.GetVersion;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.RequestBase;
import net.twasi.obsremotejava.requests.RequestType;

public class GetVersionRequest extends RequestBase {
    public GetVersionRequest(OBSCommunicator com) {
        super(RequestType.GetVersion);
        com.messageTypes.put(getMessageId(), GetVersionResponse.class);
    }
}
