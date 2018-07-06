package net.diespendendose.obsremotejava.requests.SetPreviewScene;

import com.google.gson.annotations.SerializedName;
import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class SetPreviewSceneRequest extends BaseRequest {
    @SerializedName("scene-name")
    private String sceneName;

    public SetPreviewSceneRequest(OBSCommunicator com, String name) {
        super(RequestType.SetPreviewScene);

        this.sceneName = name;

        com.messageTypes.put(getMessageId(), SetPreviewSceneResponse.class);
    }
}
