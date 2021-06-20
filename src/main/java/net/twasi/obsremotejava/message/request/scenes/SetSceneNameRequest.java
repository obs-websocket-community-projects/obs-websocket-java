package net.twasi.obsremotejava.message.request.scenes;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class SetSceneNameRequest extends Request {
    private final Data requestData;

    public SetSceneNameRequest(String sceneName, String newSceneName) {
        super(Type.SetSceneName);

        this.requestData = Data.builder().sceneName(sceneName).newSceneName(newSceneName).build();
    }

    @Getter
    @ToString
    static class Data extends SceneRequest.Data {
        @NonNull
        private final String newSceneName;

        @Builder
        Data(String sceneName, String newSceneName) {
            super(sceneName);

            this.newSceneName = newSceneName;
        }
    }
}
