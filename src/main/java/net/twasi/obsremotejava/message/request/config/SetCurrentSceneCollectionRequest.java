package net.twasi.obsremotejava.message.request.config;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetCurrentSceneCollectionRequest extends SceneCollectionRequest {
    private final Data requestData;

    @Builder
    private SetCurrentSceneCollectionRequest(String sceneCollectionName) {
        super(Type.SetCurrentSceneCollection);

        this.requestData = Data.builder().sceneCollectionName(sceneCollectionName).build();
    }
}
