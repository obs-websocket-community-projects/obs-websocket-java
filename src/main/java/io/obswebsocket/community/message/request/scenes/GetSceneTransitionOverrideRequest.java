package io.obswebsocket.community.message.request.scenes;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneTransitionOverrideRequest extends SceneRequest {
    private final Data requestData;

    @Builder
    private GetSceneTransitionOverrideRequest(String sceneName) {
        super(Type.GetSceneTransitionOverride);

        this.requestData = Data.builder().sceneName(sceneName).build();
    }
}
