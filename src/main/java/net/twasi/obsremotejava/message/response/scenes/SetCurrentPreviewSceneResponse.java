package net.twasi.obsremotejava.message.response.scenes;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class SetCurrentPreviewSceneResponse extends RequestResponse {
    public SetCurrentPreviewSceneResponse() {
        super(Request.Type.SetCurrentPreviewScene);
    }
}
