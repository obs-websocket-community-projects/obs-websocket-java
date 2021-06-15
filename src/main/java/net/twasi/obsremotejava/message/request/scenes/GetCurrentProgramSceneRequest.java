package net.twasi.obsremotejava.message.request.scenes;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetCurrentProgramSceneRequest extends Request {
    public GetCurrentProgramSceneRequest() {
        super(Type.GetCurrentProgramScene);
    }
}
