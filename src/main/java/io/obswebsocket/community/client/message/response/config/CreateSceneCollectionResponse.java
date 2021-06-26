package io.obswebsocket.community.client.message.response.config;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class CreateSceneCollectionResponse extends RequestResponse {
    public CreateSceneCollectionResponse() {
        super(Request.Type.CreateSceneCollection);
    }
}
