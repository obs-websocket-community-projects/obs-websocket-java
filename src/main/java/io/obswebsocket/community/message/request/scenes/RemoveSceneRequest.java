package io.obswebsocket.community.message.request.scenes;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RemoveSceneRequest extends SceneRequest {
    private final Data requestData;

    @Builder
    private RemoveSceneRequest(String sceneName) {
        super(Type.RemoveScene);

        this.requestData = Data.builder().sceneName(sceneName).build();
    }
}
