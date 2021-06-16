package net.twasi.obsremotejava.message.response.scenes;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class SetCurrentProgramSceneResponse extends RequestResponse {
    public SetCurrentProgramSceneResponse() {
        super(Request.Type.SetCurrentProgramScene);
    }
}
