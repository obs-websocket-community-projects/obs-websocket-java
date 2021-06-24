package io.obswebsocket.community.message.request.sceneItems;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import io.obswebsocket.community.message.request.Request;

@Getter
@ToString(callSuper = true)
abstract class SceneItemRequest extends Request {
    SceneItemRequest(Type type) {
        super(type);
    }

    @Getter
    @ToString
    @SuperBuilder
    static class Data {
        @NonNull
        private final String sceneName;
    }

    @Getter
    @ToString(callSuper = true)
    @SuperBuilder
    static class DataWithId extends Data {
        @NonNull
        private final Integer sceneItemId;
    }
}
