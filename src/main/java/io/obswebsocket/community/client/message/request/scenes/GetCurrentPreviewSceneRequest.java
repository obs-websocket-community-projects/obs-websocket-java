package io.obswebsocket.community.client.message.request.scenes;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetCurrentPreviewSceneRequest extends Request {
    @Builder
    private GetCurrentPreviewSceneRequest() {
        super(Type.GetCurrentPreviewScene);
    }
}
