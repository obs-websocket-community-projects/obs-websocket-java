package io.obswebsocket.community.client.message.response.scenes;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class SetCurrentPreviewSceneResponse extends RequestResponse {
    public SetCurrentPreviewSceneResponse() {
        super(Request.Type.SetCurrentPreviewScene);
    }
}
