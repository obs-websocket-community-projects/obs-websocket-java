package net.diespendendose.obsremotejava.requests.GetTransitionList;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class GetTransitionListRequest extends BaseRequest {
    public GetTransitionListRequest(OBSCommunicator com) {
        super(RequestType.GetTransitionList);

        com.messageTypes.put(getMessageId(), GetTransitionListResponse.class);
    }
}
