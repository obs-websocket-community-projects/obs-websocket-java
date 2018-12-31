package net.twasi.obsremotejava.requests.SetPreviewScene;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

public class SetPreviewSceneRequest extends BaseRequest {
    @SerializedName("scene-name")
    private String sceneName;

    public SetPreviewSceneRequest(OBSCommunicator com, String name) {
        super(RequestType.SetPreviewScene);

        this.sceneName = name;

        com.messageTypes.put(getMessageId(), SetPreviewSceneResponse.class);
    }
}
