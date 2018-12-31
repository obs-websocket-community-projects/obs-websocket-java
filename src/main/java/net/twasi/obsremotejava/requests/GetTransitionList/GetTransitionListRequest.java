package net.twasi.obsremotejava.requests.GetTransitionList;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class GetTransitionListRequest extends BaseRequest {
    public GetTransitionListRequest(OBSCommunicator com) {
        super(RequestType.GetTransitionList);

        com.messageTypes.put(getMessageId(), GetTransitionListResponse.class);
    }
}
