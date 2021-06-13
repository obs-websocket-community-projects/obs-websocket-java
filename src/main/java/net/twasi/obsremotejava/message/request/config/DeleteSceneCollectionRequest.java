package net.twasi.obsremotejava.message.request.config;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class DeleteSceneCollectionRequest extends SceneCollectionRequest {
    public DeleteSceneCollectionRequest(String sceneCollectionName) {
        super(Type.DeleteSceneCollection, sceneCollectionName);
    }
}
