package io.obswebsocket.community.message.request.config;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import io.obswebsocket.community.message.request.Request;

@Getter
@ToString(callSuper = true)
abstract class SceneCollectionRequest extends Request {
    SceneCollectionRequest(Request.Type requestType) {
        super(requestType);
    }

    @Getter
    @ToString
    @SuperBuilder
    static class Data {
        @NonNull
        private final String sceneCollectionName;
    }
}
