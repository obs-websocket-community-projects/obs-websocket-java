package io.obswebsocket.community.message.response.sceneItems;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;
import io.obswebsocket.community.model.SceneItem;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class GetSceneItemListResponse extends RequestResponse {
    private Data responseData;

    public GetSceneItemListResponse() {
        super(Request.Type.GetSceneItemList);
    }

    @Getter
    @ToString
    public static class Data {
        private List<SceneItem> sceneItems;
    }
}
