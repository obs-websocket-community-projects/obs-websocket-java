package net.diespendendose.obsremotejava.requests.SetCurrentScene;

import com.google.gson.annotations.SerializedName;
import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class SetCurrentSceneRequest extends BaseRequest {
    @SerializedName("scene-name")
    private String scene;

    public SetCurrentSceneRequest(OBSCommunicator com, String scene) {
        super(RequestType.SetCurrentScene);

        this.scene = scene;

        com.messageTypes.put(getMessageId(), SetCurrentSceneResponse.class);
    }

    public String getScene() {
        return scene;
    }
}
