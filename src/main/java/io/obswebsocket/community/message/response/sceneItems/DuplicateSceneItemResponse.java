package io.obswebsocket.community.message.response.sceneItems;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class DuplicateSceneItemResponse extends RequestResponse {
    private Data responseData;

    public DuplicateSceneItemResponse() {
        super(Request.Type.DuplicateSceneItem);
    }

    @Getter
    @ToString
    public static class Data {
        private Integer sceneItemId;
    }
}
