package net.twasi.obsremotejava.message.request.scenes;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetCurrentPreviewSceneRequest extends Request {
    @Builder
    private GetCurrentPreviewSceneRequest() {
        super(Type.GetCurrentPreviewScene);
    }
}
