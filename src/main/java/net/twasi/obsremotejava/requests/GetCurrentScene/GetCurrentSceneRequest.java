package net.twasi.obsremotejava.requests.GetCurrentScene;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class GetCurrentSceneRequest extends BaseRequest {
    public GetCurrentSceneRequest(OBSCommunicator com) {
        super(RequestType.GetCurrentScene);

        com.messageTypes.put(getMessageId(), GetCurrentSceneResponse.class);
    }
}
