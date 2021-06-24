package io.obswebsocket.community.message.response.config;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;
import io.obswebsocket.community.model.SceneCollection;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class GetSceneCollectionListResponse extends RequestResponse {
    private Data responseData;

    public GetSceneCollectionListResponse() {
        super(Request.Type.GetSceneCollectionList);
    }

    @Getter
    @ToString
    public static class Data {
        private List<SceneCollection> sceneCollections;
        private String currentSceneCollectionName;
    }
}
