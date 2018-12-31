package net.twasi.obsremotejava.requests.SetCurrentScene;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

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
