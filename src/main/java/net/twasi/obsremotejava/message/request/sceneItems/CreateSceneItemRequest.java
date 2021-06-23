package net.twasi.obsremotejava.message.request.sceneItems;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class CreateSceneItemRequest extends SceneItemRequest {
    private final Data requestData;

    @Builder
    private CreateSceneItemRequest(String sceneName, String inputName) {
        super(Type.CreateSceneItem);

        this.requestData = Data.builder().sceneName(sceneName).inputName(inputName).build();
    }

    @Getter
    @ToString(callSuper = true)
    @SuperBuilder
    static class Data extends SceneItemRequest.Data {
        @NonNull
        private final String inputName;
    }
}
