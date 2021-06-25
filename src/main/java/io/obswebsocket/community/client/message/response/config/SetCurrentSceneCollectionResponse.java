package io.obswebsocket.community.client.message.response.config;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class SetCurrentSceneCollectionResponse extends RequestResponse {
    public SetCurrentSceneCollectionResponse() {
        super(Request.Type.SetCurrentSceneCollection);
    }
}
