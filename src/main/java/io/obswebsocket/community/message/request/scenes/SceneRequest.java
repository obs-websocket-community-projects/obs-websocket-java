package io.obswebsocket.community.message.request.scenes;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import io.obswebsocket.community.message.request.Request;

@Getter
@ToString(callSuper = true)
abstract class SceneRequest extends Request {
    SceneRequest(Type requestType) {
        super(requestType);
    }

    @Getter
    @ToString
    @SuperBuilder
    static class Data {
        @NonNull
        private final String sceneName;
    }
}
