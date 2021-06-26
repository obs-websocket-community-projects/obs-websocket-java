package io.obswebsocket.community.client.message.response.sceneItems;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class SetSceneItemIndexResponse extends RequestResponse {
    public SetSceneItemIndexResponse() {
        super(Request.Type.SetSceneItemIndex);
    }
}
