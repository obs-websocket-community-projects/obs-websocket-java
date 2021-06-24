package io.obswebsocket.community.message.response.sceneItems;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class GetSceneItemColorResponse extends RequestResponse {
    private Data responseData;

    public GetSceneItemColorResponse() {
        super(Request.Type.GetSceneItemColor);
    }

    @Getter
    @ToString
    public static class Data {
        private Integer sceneItemColor;
    }
}
