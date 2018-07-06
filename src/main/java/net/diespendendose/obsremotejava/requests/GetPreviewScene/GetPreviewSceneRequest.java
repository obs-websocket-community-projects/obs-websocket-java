package net.diespendendose.obsremotejava.requests.GetPreviewScene;

import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class GetPreviewSceneRequest extends BaseRequest {
    public GetPreviewSceneRequest(OBSCommunicator com) {
        super(RequestType.GetPreviewScene);

        com.messageTypes.put(getMessageId(), GetPreviewSceneResponse.class);
    }
}
