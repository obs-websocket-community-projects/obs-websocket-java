package net.twasi.obsremotejava.message.request.scenes;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CreateSceneRequest extends SceneRequest {
    private final Data requestData;

    public CreateSceneRequest(String sceneName) {
        super(Type.CreateScene);

        this.requestData = Data.builder().sceneName(sceneName).build();
    }
}
