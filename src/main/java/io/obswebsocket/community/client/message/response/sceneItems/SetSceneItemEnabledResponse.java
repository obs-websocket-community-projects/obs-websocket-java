package io.obswebsocket.community.client.message.response.sceneItems;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class SetSceneItemEnabledResponse extends RequestResponse {
    public SetSceneItemEnabledResponse() {
        super(Request.Type.SetSceneItemEnabled);
    }
}