package io.obswebsocket.community.client.message.response.sceneItems;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.SceneItem;
import lombok.Getter;
import lombok.ToString;
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
