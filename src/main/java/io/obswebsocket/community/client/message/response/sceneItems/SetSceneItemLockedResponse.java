package io.obswebsocket.community.client.message.response.sceneItems;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetSceneItemLockedResponse extends RequestResponse {
    public SetSceneItemLockedResponse() {
        super(Request.Type.SetSceneItemLocked);
    }
}
