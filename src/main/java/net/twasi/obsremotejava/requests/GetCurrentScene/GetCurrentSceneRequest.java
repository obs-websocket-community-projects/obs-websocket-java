package net.twasi.obsremotejava.requests.GetCurrentScene;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.RequestBase;
import net.twasi.obsremotejava.requests.RequestType;

public class GetCurrentSceneRequest extends RequestBase {
    public GetCurrentSceneRequest(OBSCommunicator com) {
        super(RequestType.GetCurrentScene);

//        // com.messageTypes.put(getMessageId(), GetCurrentSceneResponse.class);
    }
}
