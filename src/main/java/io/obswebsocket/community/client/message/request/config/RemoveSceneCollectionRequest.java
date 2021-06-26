package io.obswebsocket.community.client.message.request.config;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RemoveSceneCollectionRequest extends SceneCollectionRequest {
    private final Data requestData;

    @Builder
    private RemoveSceneCollectionRequest(String sceneCollectionName) {
        super(Type.RemoveSceneCollection);

        this.requestData = Data.builder().sceneCollectionName(sceneCollectionName).build();
    }
}
