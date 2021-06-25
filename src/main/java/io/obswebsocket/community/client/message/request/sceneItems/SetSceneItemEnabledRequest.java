package io.obswebsocket.community.client.message.request.sceneItems;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetSceneItemEnabledRequest extends SceneItemRequest {
    private final Data requestData;

    @Builder
    private SetSceneItemEnabledRequest(String sceneName, Integer sceneItemId, Boolean sceneItemEnabled) {
        super(Type.SetSceneItemEnabled);

        this.requestData = Data.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemEnabled(sceneItemEnabled).build();
    }

    @Getter
    @ToString(callSuper = true)
    @SuperBuilder
    static class Data extends SceneItemRequest.DataWithId {
        @NonNull
        private final Boolean sceneItemEnabled;
    }
}
