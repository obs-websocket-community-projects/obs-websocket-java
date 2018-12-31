package net.twasi.obsremotejava.requests.GetPreviewScene;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class GetPreviewSceneRequest extends BaseRequest {
    public GetPreviewSceneRequest(OBSCommunicator com) {
        super(RequestType.GetPreviewScene);

        com.messageTypes.put(getMessageId(), GetPreviewSceneResponse.class);
    }
}
