package net.twasi.obsremotejava.message.request.scenes;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RemoveSceneRequest extends SceneRequest {
    private final Data requestData;

    public RemoveSceneRequest(String sceneName) {
        super(Type.RemoveScene);

        this.requestData = Data.builder().sceneName(sceneName).build();
    }
}
