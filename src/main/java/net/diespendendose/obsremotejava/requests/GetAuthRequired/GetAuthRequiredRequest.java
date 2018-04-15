package net.diespendendose.obsremotejava.requests.GetAuthRequired;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class GetAuthRequiredRequest extends BaseRequest {

    public GetAuthRequiredRequest(OBSCommunicator com) {
        super(RequestType.GetAuthRequired);
        com.messageTypes.put(getMessageId(), GetAuthRequiredResponse.class);
    }
}