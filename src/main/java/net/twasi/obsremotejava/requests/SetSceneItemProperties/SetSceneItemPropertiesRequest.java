package net.twasi.obsremotejava.requests.SetSceneItemProperties;

import com.google.gson.annotations.SerializedName;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.BaseRequest;
import net.twasi.obsremotejava.requests.RequestType;

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

        log.debug("MSG ID: " + getMessageId());

        com.messageTypes.put(getMessageId(), SetSceneItemPropertiesResponse.class);
    }
}
