package io.obswebsocket.community.message.response.sceneItems;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class RemoveSceneItemResponse extends RequestResponse {
    public RemoveSceneItemResponse() {
        super(Request.Type.RemoveSceneItem);
    }
}
