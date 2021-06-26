package io.obswebsocket.community.client.message.request.sceneItems;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetSceneItemIndexRequest extends SceneItemRequest {
    private final Data requestData;

    @Builder
    private SetSceneItemIndexRequest(String sceneName, Integer sceneItemId, Integer sceneItemIndex) {
        super(Type.SetSceneItemIndex);

        this.requestData = Data.builder().sceneName(sceneName).sceneItemId(sceneItemId).sceneItemIndex(sceneItemIndex).build();
    }

    @Getter
    @ToString(callSuper = true)
    @SuperBuilder
    static class Data extends DataWithId {
        @NonNull
        private final Integer sceneItemIndex;
    }
}
