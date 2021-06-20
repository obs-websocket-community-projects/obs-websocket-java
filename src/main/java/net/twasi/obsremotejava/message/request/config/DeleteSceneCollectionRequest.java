package net.twasi.obsremotejava.message.request.config;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class DeleteSceneCollectionRequest extends SceneCollectionRequest {
    private final Data requestData;

    @Builder
    private DeleteSceneCollectionRequest(String sceneCollectionName) {
        super(Type.DeleteSceneCollection);

        this.requestData = Data.builder().sceneCollectionName(sceneCollectionName).build();
    }
}
