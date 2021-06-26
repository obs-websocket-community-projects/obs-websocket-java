package io.obswebsocket.community.client.message.response.scenes;

import java.util.List;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Scene;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneListResponse extends RequestResponse {
    private Data responseData;

    public GetSceneListResponse() {
        super(Request.Type.GetSceneList);
    }

    @AllArgsConstructor
    @Getter
    @ToString
    public static class Data {
        private final String currentProgramSceneName;
        private final String currentPreviewSceneName;
        private final List<Scene> scenes;
    }
}
