package net.twasi.obsremotejava.message.request.scenes;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
abstract class SceneRequest extends Request {
    public SceneRequest(Type requestType) {
        super(requestType);
    }

    @Getter
    @ToString
    @Builder
    static class Data {
        @NonNull
        private final String sceneName;
    }
}
