package io.obswebsocket.community.client.message.request.scenes;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class DeleteSceneTransitionOverrideRequest extends SceneRequest {
    private final Data requestData;

    @Builder
    private DeleteSceneTransitionOverrideRequest(String sceneName) {
        super(Type.DeleteSceneTransitionOverride);

        this.requestData = Data.builder().sceneName(sceneName).build();
    }
}
