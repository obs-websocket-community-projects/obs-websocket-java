package net.twasi.obsremotejava.requests.GetTransitionList;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.RequestBase;
import net.twasi.obsremotejava.requests.RequestType;

public class GetTransitionListRequest extends RequestBase {
    public GetTransitionListRequest(OBSCommunicator com) {
        super(RequestType.GetTransitionList);

        com.messageTypes.put(getMessageId(), GetTransitionListResponse.class);
    }
}
