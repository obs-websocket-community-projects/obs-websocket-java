package io.obswebsocket.community.message.request.sceneItems;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneItemColorRequest extends SceneItemRequest {
    private final DataWithId requestData;

    @Builder
    private GetSceneItemColorRequest(String sceneName, Integer sceneItemId) {
        super(Type.GetSceneItemColor);

        this.requestData = DataWithId.builder().sceneName(sceneName).sceneItemId(sceneItemId).build();
    }
}
