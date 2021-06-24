package io.obswebsocket.community.message.request.scenes;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetCurrentPreviewSceneRequest extends Request {
    @Builder
    private GetCurrentPreviewSceneRequest() {
        super(Type.GetCurrentPreviewScene);
    }
}
