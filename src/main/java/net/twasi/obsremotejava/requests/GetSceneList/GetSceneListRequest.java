package net.twasi.obsremotejava.requests.GetSceneList;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class GetSceneListRequest extends BaseRequest {
    public GetSceneListRequest(OBSCommunicator com) {
        super(RequestType.GetSceneList);
        com.messageTypes.put(getMessageId(), GetSceneListResponse.class);
    }
}
