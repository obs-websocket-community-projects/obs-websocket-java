package net.twasi.obsremotejava.message.request.config;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import net.twasi.obsremotejava.message.request.Request;

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
