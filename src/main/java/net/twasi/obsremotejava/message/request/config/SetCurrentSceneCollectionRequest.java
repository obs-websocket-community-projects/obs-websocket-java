package net.twasi.obsremotejava.message.request.config;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetCurrentSceneCollectionRequest extends SceneCollectionRequest {
    public SetCurrentSceneCollectionRequest(String sceneCollectionName) {
        super(Type.SetCurrentSceneCollection, sceneCollectionName);
    }
}
