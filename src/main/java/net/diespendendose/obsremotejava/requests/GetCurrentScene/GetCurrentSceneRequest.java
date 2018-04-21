package net.diespendendose.obsremotejava.requests.GetCurrentScene;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class GetCurrentSceneRequest extends BaseRequest {
    public GetCurrentSceneRequest(OBSCommunicator com) {
        super(RequestType.GetCurrentScene);

        com.messageTypes.put(getMessageId(), GetCurrentSceneResponse.class);
    }
}
