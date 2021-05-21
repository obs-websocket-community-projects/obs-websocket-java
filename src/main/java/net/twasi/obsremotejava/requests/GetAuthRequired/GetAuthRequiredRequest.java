package net.twasi.obsremotejava.requests.GetAuthRequired;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.RequestBase;
import net.twasi.obsremotejava.requests.RequestType;

public class GetAuthRequiredRequest extends RequestBase {

    public GetAuthRequiredRequest(OBSCommunicator com) {
        super(RequestType.GetAuthRequired);
        com.messageTypes.put(getMessageId(), GetAuthRequiredResponse.class);
    }
}