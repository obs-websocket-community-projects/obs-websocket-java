package net.twasi.obsremotejava.message.request.config;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
abstract class SceneCollectionRequest extends Request {
    private final Data requestData;

    SceneCollectionRequest(Request.Type requestType, String sceneCollectionName) {
        super(requestType);

        this.requestData = Data.builder().sceneCollectionName(sceneCollectionName).build();
    }

    @Getter
    @ToString
    @Builder
    static class Data {
        @NonNull
        private final String sceneCollectionName;
    }
}
