package net.twasi.obsremotejava.message.request.config;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class DeleteSceneCollectionRequest extends SceneCollectionRequest {
    private final Data requestData;

    public DeleteSceneCollectionRequest(String sceneCollectionName) {
        super(Type.DeleteSceneCollection);

        this.requestData = Data.builder().sceneCollectionName(sceneCollectionName).build();
    }
}
