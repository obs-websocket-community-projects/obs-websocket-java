package io.obswebsocket.community.message.response.sceneItems;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class GetSceneItemEnabledResponse extends RequestResponse {
    private Data responseData;

    public GetSceneItemEnabledResponse() {
        super(Request.Type.GetSceneItemEnabled);
    }

    @Getter
    @ToString
    public static class Data {
        private Boolean sceneItemEnabled;
    }
}
