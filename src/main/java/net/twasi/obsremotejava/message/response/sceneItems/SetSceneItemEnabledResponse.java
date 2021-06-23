package net.twasi.obsremotejava.message.response.sceneItems;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class SetSceneItemEnabledResponse extends RequestResponse {
    public SetSceneItemEnabledResponse() {
        super(Request.Type.SetSceneItemEnabled);
    }
}
