package net.twasi.obsremotejava.message.request.scenes;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class CreateSceneRequest extends Request {
    private final Data requestData;

    public CreateSceneRequest(String sceneName) {
        super(Type.CreateScene);

        this.requestData = Data.builder().sceneName(sceneName).build();
    }

    @Getter
    @ToString
    @Builder
    static class Data {
        @NonNull
        private final String sceneName;
    }
}
