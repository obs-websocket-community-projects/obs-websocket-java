package io.obswebsocket.community.client.message.response.scenes;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetCurrentPreviewSceneResponse extends CurrentSceneResponse {
    private Data responseData;

    public GetCurrentPreviewSceneResponse() {
        super(Request.Type.GetCurrentPreviewScene);
    }
}
