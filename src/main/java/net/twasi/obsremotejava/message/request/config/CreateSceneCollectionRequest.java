package net.twasi.obsremotejava.message.request.config;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CreateSceneCollectionRequest extends SceneCollectionRequest {
    public final Data requestData;

    public CreateSceneCollectionRequest(String sceneCollectionName) {
        super(Type.SetCurrentSceneCollection);

        this.requestData = Data.builder().sceneCollectionName(sceneCollectionName).build();
    }
}
