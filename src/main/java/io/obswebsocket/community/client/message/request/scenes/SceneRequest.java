package io.obswebsocket.community.client.message.request.scenes;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

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
