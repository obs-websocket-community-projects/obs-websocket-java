package net.diespendendose.obsremotejava.requests.SetSceneItemProperties;

import com.google.gson.annotations.SerializedName;
import net.diespendendose.obsremotejava.OBSCommunicator;
import net.diespendendose.obsremotejava.requests.BaseRequest;
import net.diespendendose.obsremotejava.requests.RequestType;

public class SetSceneItemPropertiesRequest extends BaseRequest {
    @SerializedName("scene-name")
    private String scene;
    private String item;
    private boolean visible;

    public SetSceneItemPropertiesRequest(OBSCommunicator com, String scene, String source, boolean visible) {
        super(RequestType.SetSceneItemProperties);

        this.scene = scene;
        this.item = source;
        this.visible = visible;

        System.out.println("MSG ID: " + getMessageId());

        com.messageTypes.put(getMessageId(), SetSceneItemPropertiesResponse.class);
    }
}
