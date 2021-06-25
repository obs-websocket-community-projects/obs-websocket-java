package io.obswebsocket.community.client.message.response.sceneItems;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class GetSceneItemLockedResponse extends RequestResponse {
    private Data responseData;

    public GetSceneItemLockedResponse() {
        super(Request.Type.GetSceneItemLocked);
    }

    @Getter
    @ToString
    public static class Data {
        private Boolean sceneItemLocked;
    }
}
