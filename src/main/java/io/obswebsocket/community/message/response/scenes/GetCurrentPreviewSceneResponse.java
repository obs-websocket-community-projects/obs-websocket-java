package io.obswebsocket.community.message.response.scenes;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetCurrentPreviewSceneResponse extends CurrentSceneResponse {
    private Data responseData;

    public GetCurrentPreviewSceneResponse() {
        super(Request.Type.GetCurrentPreviewScene);
    }
}
