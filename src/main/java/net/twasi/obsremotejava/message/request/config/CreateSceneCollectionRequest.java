package net.twasi.obsremotejava.message.request.config;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CreateSceneCollectionRequest extends SceneCollectionRequest {
    public CreateSceneCollectionRequest(String sceneCollectionName) {
        super(Type.SetCurrentSceneCollection, sceneCollectionName);
    }
}
