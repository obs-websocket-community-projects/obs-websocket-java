package net.twasi.obsremotejava.message.request.scenes;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetCurrentProgramSceneRequest extends Request {
    @Builder
    private GetCurrentProgramSceneRequest() {
        super(Type.GetCurrentProgramScene);
    }
}
