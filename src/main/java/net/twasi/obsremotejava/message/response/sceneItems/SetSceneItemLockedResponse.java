package net.twasi.obsremotejava.message.response.sceneItems;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class SetSceneItemLockedResponse extends RequestResponse {
    public SetSceneItemLockedResponse() {
        super(Request.Type.SetSceneItemLocked);
    }
}
