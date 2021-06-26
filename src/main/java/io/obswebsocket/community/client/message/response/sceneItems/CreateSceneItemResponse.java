package io.obswebsocket.community.client.message.response.sceneItems;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class CreateSceneItemResponse extends RequestResponse {
    private Data responseData;

    public CreateSceneItemResponse() {
        super(Request.Type.CreateSceneItem);
    }

    @Getter
    @ToString
    public static class Data {
        private Integer sceneItemId;
    }
}