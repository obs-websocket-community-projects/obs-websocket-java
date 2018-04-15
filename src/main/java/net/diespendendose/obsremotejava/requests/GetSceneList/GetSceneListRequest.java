package net.diespendendose.obsremotejava.requests.GetSceneList;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class GetSceneListRequest extends BaseRequest {
    public GetSceneListRequest(OBSCommunicator com) {
        super(RequestType.GetSceneList);
        com.messageTypes.put(getMessageId(), GetSceneListResponse.class);
    }
}
